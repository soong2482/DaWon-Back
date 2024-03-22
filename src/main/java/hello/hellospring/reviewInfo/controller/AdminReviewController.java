package hello.hellospring.reviewInfo.controller;

import hello.hellospring.reviewInfo.domain.ChangeOrder;
import hello.hellospring.reviewInfo.domain.Review;
import hello.hellospring.reviewInfo.domain.UpdateReview;
import hello.hellospring.reviewInfo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AdminReviewController {

    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
    //    ${DaWonCar.backEndPoint}/

    private final ReviewService reviewService;

    @PostMapping("${DaWonCar.backEndPoint}/Admin/Review/Insert")
    @ResponseBody
    public String ReviewInsert(@RequestParam("Review_IMG")MultipartFile file,@RequestParam("json") String json) throws IOException {
        return reviewService.InsertReview(file,json);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/Review/Delete")
    @ResponseBody
    public String DeleteReview(@RequestHeader("CustomerReviewCode") Long CustomerReviewCode){
        return reviewService.DeleteReview(CustomerReviewCode);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/Review/Update")
    @ResponseBody
    public String UpdateReview(@RequestBody UpdateReview updateReview){
        return reviewService.UpdateReview(updateReview);
    }

    @PostMapping("${DaWonCar.backEndPoint}/Admin/Review/ChangeOrder")
    @ResponseBody
    public String ChangeOrder(@RequestBody ChangeOrder changeOrder){
        return reviewService.ChangeReviewOrder(changeOrder);
    }


}
