package com.example.MaxiPet.DTO.Builders;

import com.example.MaxiPet.DTO.OrderDTO;
import com.example.MaxiPet.DTO.ReviewDTO;
import com.example.MaxiPet.Entity.Order;
import com.example.MaxiPet.Entity.Review;

import java.util.Collections;
import java.util.List;

public class ReviewBuilder {

    public static ReviewDTO toReviewDTO(Review review) {
        return ReviewDTO.builder()
                .build();
    }

    public static List<ReviewDTO> toReviewDTOList(List<Review> reviewList) {
        if (reviewList == null || reviewList.isEmpty()) {
            return Collections.emptyList();
        }
        return reviewList.stream().map(r -> ReviewBuilder.toReviewDTO(r)).toList();
    }
}
