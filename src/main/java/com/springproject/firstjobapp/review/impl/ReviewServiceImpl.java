package com.springproject.firstjobapp.review.impl;

import com.springproject.firstjobapp.company.Company;
import com.springproject.firstjobapp.company.CompanyService;
import com.springproject.firstjobapp.review.Review;
import com.springproject.firstjobapp.review.ReviewRepository;
import com.springproject.firstjobapp.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;
    public ReviewServiceImpl(ReviewRepository reviewRepository,CompanyService companyService)  {
        this.reviewRepository = reviewRepository;
        this.companyService=companyService;
    }


    @Override
    public List<Review> findAllReviews(Long companyId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company=companyService.getCompanyById(companyId);
        if(company !=null){
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Review getReview(Long companyId, Long reviewId) {
        List<Review> reviews=reviewRepository.findByCompanyId(companyId);

        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedreview) {
        if(companyService.getCompanyById(companyId)!=null){
            if(reviewRepository.findById(reviewId).isPresent()){
                updatedreview.setCompany(companyService.getCompanyById(companyId));
                updatedreview.setId(reviewId);
                reviewRepository.save(updatedreview);
                return true;
            }else {
                return false;
            }
        }else{
            return false;
        }
    }


}
