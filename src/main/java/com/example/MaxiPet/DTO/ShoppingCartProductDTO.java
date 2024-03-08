package com.example.MaxiPet.DTO;

import com.example.MaxiPet.Entity.Product;
import com.example.MaxiPet.Entity.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ShoppingCartProductDTO {
    private Integer id;
    private UserDTO user;
    private ProductDTO product;
    private Integer quantity;
}
