package hello.hellospring.reviewInfo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.hellospring.reviewInfo.domain.ChangeOrder;
import hello.hellospring.reviewInfo.domain.Review;
import hello.hellospring.reviewInfo.domain.UpdateReview;
import hello.hellospring.reviewInfo.mapper.ReviewMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Value;
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
@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewMapper reviewMapper;

    @Value("${custom.genFileDirPath}")
    private String uploadDir;

    @Async
    public String InsertReview(MultipartFile file, String json) throws IOException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Review review = objectMapper.readValue(json, Review.class);
            log.info("Insert Review.");
            review.setCustomerReviewOrder(reviewMapper.getLastOrder() + 1);
            String filename = UploadFile(file);
            if (filename.equals("UploadFailed")) {
                return "UploadFailed";
            }
            review.setCustomerReviewImgURL("/Review/" + filename);
            reviewMapper.InsertReview(review);
            return "Success";
        } catch (IOException e) {
            log.error("Failed to Insert Review: {}", e.getMessage());
            return "Failed";
        }
    }
    private String UploadFile(MultipartFile file) throws IOException {
        try {
            log.info("UploadFile-CustomerReview");
            Path uploadPath = Paths.get(uploadDir + "/Review");
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String extension = "";
            int dotIndex = file.getOriginalFilename().lastIndexOf('.');
            if (dotIndex > 0 && dotIndex < file.getOriginalFilename().length() - 1) {
                extension = file.getOriginalFilename().substring(dotIndex);
            }
            String fileName = currentTime.format(formatter) + "_" + extension;
            Path filePath = uploadPath.resolve(fileName);
            byte[] bytes = file.getBytes();
            Files.write(filePath, bytes);
            return fileName;
        } catch (IOException e) {
            log.error("Failed to upload Review file: {}", e.getMessage());
            return "UploadFailed";
        }
    }

    public List<Review> Review(){
        try{
            log.info("Select Review List");
            List<Review> reviews = reviewMapper.Review();
            log.info("result size : {}",reviews.size());
            return reviews;
        }catch (Exception e){
            log.error("Failed to get Review List: {}",e.getMessage());
            return Collections.emptyList();
        }
    }

    public String DeleteReview(Long CustomerReviewCode){
        try{
            log.info("Delete Review {}",CustomerReviewCode);
            reviewMapper.DeleteReview(CustomerReviewCode);
            log.info("Delete Review Successfully");
            return "Success";
        }catch (Exception e){
            log.error("Failed to Delete Review file: {}",e.getMessage());
            return "Failed";
        }
    }

    public String UpdateReview(UpdateReview updateReview){
        try{
            log.info("Update Review {}",updateReview.getCustomerReviewCode());
            reviewMapper.UpdateReview(updateReview.getCustomerReviewCode(),updateReview.getCustomerReviewTextArea());
            log.info("Update Review Success");
            return "Success";
        }catch (Exception e){
            log.error("Failed to Update Review file:{}",e.getMessage());
            return "Failed";
        }
    }
    public String ChangeReviewOrder(ChangeOrder changeOrder){
        try{
            log.info("Change Reivew Order {}",changeOrder.getCustomerReviewCode()+".No"+changeOrder.getChangeCustomerReviewCode());
            reviewMapper.ChangeReviewOrder(changeOrder.getCustomerReviewCode(),changeOrder.getChangeCustomerReviewOrder());
            reviewMapper.ChangeReviewOrder(changeOrder.getChangeCustomerReviewCode(),changeOrder.getCustomerReviewOrder());
            log.info("Change Review Order Success");
            return "Success";
        }catch (Exception e){
            log.error("Failed to Change Review file:{}",e.getMessage());
            return "Failed";
        }
    }
}
