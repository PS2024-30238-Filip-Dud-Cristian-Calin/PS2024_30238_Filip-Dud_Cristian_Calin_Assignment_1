package com.example.MaxiPet.DTO;

import com.example.MaxiPet.Entity.OrderProduct;
import com.example.MaxiPet.Entity.Review;
import com.example.MaxiPet.Entity.ShoppingCartProduct;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
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
    private List<ShoppingCartProductDTO> shoppingCartProductList;
    private List<OrderProductDTO> orderProductList;
    private List<ReviewDTO> reviewList;
}
