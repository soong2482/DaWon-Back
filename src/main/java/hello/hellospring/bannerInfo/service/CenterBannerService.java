package hello.hellospring.bannerInfo.service;

import hello.hellospring.bannerInfo.domain.CenterBanner;
import hello.hellospring.bannerInfo.mapper.BannerMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
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
public class CenterBannerService {
    private final BannerMapper bannerMapper;

    @Value("${custom.genFileDirPath}")
    private String uploadDir;

    public String InsertCenterBanner(MultipartFile file, String name) throws IOException {
        try {
            CenterBanner centerBanner = new CenterBanner();
            log.info("Insert CenterBanner");
            Path uploadPath = Paths.get(uploadDir+"/CenterBanner");
            byte[] bytes = file.getBytes();
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String extension = "";
            int dotIndex =file.getOriginalFilename().lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < file.getOriginalFilename().length() - 1) {
                extension =file.getOriginalFilename().substring(dotIndex);
            }
            String fileName = currentTime.format(formatter) + "_" + extension;
            Path filePath = uploadPath.resolve(fileName);

            Files.write(filePath, bytes);
            centerBanner.setCenterBannerLook(false);
            centerBanner.setCenterBannerName(name);
            centerBanner.setCenterBannerImgURL("/CenterBanner/"+fileName);
            bannerMapper.InsertCenterBanner(centerBanner);
            log.info("Insert CenterBanner Success");
            return "Success";
        } catch (IOException | DataAccessException e) {
            log.error("Failed to insert CenterBanner", e);
            return "Failed";
        }
    }
    public String DeleteCenterBanner(Long centerBannerCode) {
        try {
            log.info("Deleting CenterBanner {}", centerBannerCode);
            bannerMapper.DeleteCenterBanner(centerBannerCode);
            log.info("Deleted CenterBanner Successfully");
            return "Success";
        } catch (DataAccessException e) {
            log.error("Failed to delete CenterBanner with code {}", centerBannerCode, e);
            return "Failed";
        }
    }
    public String ChangeCenterBannerOrder(Long centerBannerCode) {
        try {
            log.info("Changing CenterBanner Order");
            bannerMapper.UpdateCenterBanner();
            bannerMapper.UpdateCenterBannerLook(centerBannerCode);
            log.info("Changed CenterBanner Look: {}", centerBannerCode);
            return "Success";
        } catch (DataAccessException e) {
            log.error("Failed to change CenterBanner Order", e);
            return "Failed";
        }
    }

    public List<CenterBanner> CenterBannerList(){
        try {
            log.info("Select CenterBannerList");
            List<CenterBanner> centerBannerList = bannerMapper.CenterBanner();
            return centerBannerList;
        } catch (Exception e) {
            log.error("Failed to retrieve CenterBanner list", e);
            return Collections.emptyList();
        }
    }

    public List<CenterBanner> CenterBanner(){
        try{
            log.info("Select CenterBanner");
            List<CenterBanner> centerBanner = bannerMapper.CenterBannerHome();
            return centerBanner;
        } catch (Exception e) {
            log.error("Failed to retrieve CenterBanner", e);
            return Collections.emptyList();
        }
    }

}
