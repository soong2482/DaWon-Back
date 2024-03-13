package hello.hellospring.bannerInfo.service;

import hello.hellospring.bannerInfo.domain.ChangeOrder;
import hello.hellospring.bannerInfo.domain.HomeBanner;
import hello.hellospring.bannerInfo.mapper.BannerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeBannerService {
    private final BannerMapper bannerMapper;

    @Value("${custom.genFileDirPath}")
    private String uploadDir;

    public String InsertHomeBanner(MultipartFile file, String name) throws IOException{
        try {
            Long getOrder = bannerMapper.getLastOrder();
            HomeBanner homeBanner = new HomeBanner();
            homeBanner.setHomeBannerOrder(getOrder+1);
            log.info("Inserting HomeBanner");
            Path uploadPath = Paths.get(uploadDir + "/HomeBanner");
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String extension = "";
            int dotIndex =file.getOriginalFilename().lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < file.getOriginalFilename().length() - 1) {
                extension =file.getOriginalFilename().substring(dotIndex);
            }
            String fileName = currentTime.format(formatter) + "_" + extension;
            Path filePath = uploadPath.resolve(fileName);
            byte[] bytes = file.getBytes();
            Files.write(filePath, bytes);
            homeBanner.setHomeBannerImgURL("/HomeBanner/"+fileName);
            homeBanner.setHomeBannerName(name);
            bannerMapper.InsertHomeBanner(homeBanner);
            log.info("Inserted HomeBanner Successfully");
            return "Success";
        } catch (IOException | DataAccessException e) {
            log.error("Failed to insert HomeBanner", e);
            return "Failed";
        }
    }
    @Async
    public String DeleteHomeBanner(Long homeBannerCode) {
        try {
            log.info("Deleting HomeBanner {}", homeBannerCode);
            bannerMapper.UpdateDeleteHomeBanner(homeBannerCode);
            bannerMapper.DeleteHomeBanner(homeBannerCode);
            log.info("Deleted HomeBanner Successfully");
            return "Success";
        } catch (DataAccessException e) {
            log.error("Failed to delete HomeBanner with code {}", homeBannerCode, e);
            return "Failed";
        }
    }

    public String ChangeHomeBannerOrder(ChangeOrder changeOrder) {
        try {
            log.info("Changing HomeBanner Order");
            bannerMapper.UpdateHomeBannerOrder(changeOrder.getHomeBannerCode(), changeOrder.getChangeHomeBannerOrder());
            bannerMapper.UpdateHomeBannerOrder(changeOrder.getChangeHomeBannerCode(), changeOrder.getHomeBannerOrder());
            log.info("Changed HomeBanner Order: {} moved to after {}", changeOrder.getHomeBannerCode(), changeOrder.getChangeHomeBannerCode());
            return "Success";
        } catch (DataAccessException e) {
            log.error("Failed to change HomeBanner Order", e);
            return "Failed";
        }
    }
    public List<HomeBanner> HomeBannerList(){
        try {
            log.info("Select HomeBannerList");
            List<HomeBanner> homeBannerList = bannerMapper.HomeBanner();
            return homeBannerList;
        } catch (Exception e) {
            log.error("Failed to retrieve HomeBanner list", e);
            return Collections.emptyList();
        }
    }

}
