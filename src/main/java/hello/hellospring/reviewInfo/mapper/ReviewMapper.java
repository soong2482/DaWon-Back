package hello.hellospring.reviewInfo.mapper;

import hello.hellospring.reviewInfo.domain.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReviewMapper {
    void InsertReview(Review review);

    List<Review> Review();

    void DeleteReview(Long customerReviewCode);

    void UpdateReview(Long customerReviewCode,String customerReviewTextarea);

    void ChangeReviewOrder(Long customerReviewCode,Long customerReviewOrder);
    Long getLastOrder();
}
