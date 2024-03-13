package hello.hellospring.reviewInfo.controller;

import hello.hellospring.reviewInfo.domain.Review;
import hello.hellospring.reviewInfo.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReviewController {

    @Value("${DaWonCar.backEndPoint}")
    private String BackEndpoint;
    //    ${DaWonCar.backEndPoint}/

    private final ReviewService reviewService;

    @GetMapping("${DaWonCar.backEndPoint}/CustomerReview")
    @ResponseBody
    public List<Review> reviews() {
        return reviewService.Review();
    }
}
