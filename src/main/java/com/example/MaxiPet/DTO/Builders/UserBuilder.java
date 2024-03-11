package com.example.MaxiPet.DTO.Builders;

import com.example.MaxiPet.DTO.UserDTO;
import com.example.MaxiPet.Entity.User;

public class UserBuilder {

    public static UserDTO toUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .role(user.getRole())
                .name(user.getName())
                .firstName(user.getFirstName())
                .email(user.getEmail())
                .phone(user.getPhone())
                .password(user.getPassword())
                .shoppingCartProductDTOList(ShoppingCartProductBuilder.toShoppingCartProductDTOList(user.getShoppingCartProductList()))
                .orderDTOList(OrderBuilder.toOrderDTOList(user.getOrderList()))
                .reviewDTOList(ReviewBuilder.toReviewDTOList(user.getReviewList()))
                .build();
    }

    public static User toEntity(UserDTO userDTO) {
        return User.builder()
                .id(userDTO.getId())
                .role(userDTO.getRole())
                .email(userDTO.getEmail())
                .name(userDTO.getName())
                .build();
    }
}
