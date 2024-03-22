package hello.hellospring.reviewInfo.domain;

import lombok.Data;

@Data
public class UpdateReview {
    private Long customerReviewCode;
    private String customerReviewTextArea;
}
