package com.example.MaxiPet.DTO.Builders;

import com.example.MaxiPet.DTO.ProductDTO;
import com.example.MaxiPet.Entity.Product;

public class ProductBuilder {

    public static ProductDTO toProductDTO(Product product){
        return ProductDTO.builder()
                .build();
    }
}
