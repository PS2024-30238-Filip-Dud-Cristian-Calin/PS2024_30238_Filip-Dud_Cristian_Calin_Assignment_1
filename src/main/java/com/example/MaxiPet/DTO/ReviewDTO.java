package com.example.MaxiPet.DTO;

import com.example.MaxiPet.Entity.Product;
import com.example.MaxiPet.Entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReviewDTO {

    private Integer id;
    private String text;
    private Integer rating;
    private ProductDTO product;
    private UserDTO user;
}
