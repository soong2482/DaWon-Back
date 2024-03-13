package hello.hellospring.reviewInfo.domain;

import lombok.Data;

@Data
public class ChangeOrder {
    private Long customerReviewCode;
    private Long customerReviewOrder;
    private Long changeCustomerReviewCode;
    private Long changeCustomerReviewOrder;
}
