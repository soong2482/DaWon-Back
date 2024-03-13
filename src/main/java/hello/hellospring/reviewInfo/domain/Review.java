package hello.hellospring.reviewInfo.domain;

import lombok.Data;

@Data
public class Review {
    private Long customerReviewCode;
    private String customerReviewBrand;
    private String customerReviewTextarea;
    private String customerReviewImgURL;
    private String customerReviewCarsort;
    private String customerReviewPrice;
    private String customerReviewTitle;
    private String customerReviewDate;
    private Long customerReviewOrder;
}
