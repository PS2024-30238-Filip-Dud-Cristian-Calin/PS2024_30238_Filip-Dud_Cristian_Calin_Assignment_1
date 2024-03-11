package com.example.MaxiPet.DTO;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDTO {

    private Integer id;
    private String name;
    private Float price;
    private Integer stock;
    private String category;
    private List<ShoppingCartProductDTO> shoppingCartProductDTOList;
    private List<OrderProductDTO> orderProductDTOList;
    private List<ReviewDTO> reviewDTOList;
}
