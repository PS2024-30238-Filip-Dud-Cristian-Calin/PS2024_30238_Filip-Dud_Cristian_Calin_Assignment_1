package com.example.MaxiPet.DTO;

import com.example.MaxiPet.Entity.Product;
import com.example.MaxiPet.Entity.User;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDTO {

    private Integer id;
    private String text;
    private Integer rating;
    private Integer productId;
    private Integer userId;
}
