package com.example.MaxiPet.DTO;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserDTO {

    private Integer id;
    private String role;
    private String name;
    private String firstName;
    @Email(message = "The email is not valid!")
    private String email;
    //@Pattern(regexp = "")
    private String phone;
    private String password;
    private List<ShoppingCartProductDTO> shoppingCartProductDTOList;
    private List<OrderDTO> orderDTOList;
    private List<ReviewDTO> reviewDTOList;
}
