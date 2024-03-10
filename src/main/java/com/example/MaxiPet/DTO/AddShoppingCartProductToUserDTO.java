package com.example.MaxiPet.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddShoppingCartProductToUserDTO {
    private Integer user_id;
    private Integer product_id;
    private Integer quantity;
}
