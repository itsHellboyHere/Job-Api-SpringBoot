package com.springproject.firstjobapp.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReviews(Long companyId);
    boolean addReview(Long companyId,Review review);
    Review getReview(Long companyId,Long reviewId);
    boolean updateReview(Long companyId,Long reviewId,Review updatedreview);

}
