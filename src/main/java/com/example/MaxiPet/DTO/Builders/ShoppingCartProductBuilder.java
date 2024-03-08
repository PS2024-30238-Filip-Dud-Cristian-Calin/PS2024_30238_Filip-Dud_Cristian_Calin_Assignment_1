package com.example.MaxiPet.DTO.Builders;

import com.example.MaxiPet.DTO.ShoppingCartProductDTO;
import com.example.MaxiPet.Entity.Product;
import com.example.MaxiPet.Entity.ShoppingCartProduct;
import com.example.MaxiPet.Entity.User;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

public class ShoppingCartProductBuilder {


    public static ShoppingCartProductDTO toShoppingCartProductDTO(ShoppingCartProduct shoppingCartProduct) {
        return ShoppingCartProductDTO.builder()
                .id(shoppingCartProduct.getId())
                .quantity(shoppingCartProduct.getQuantity())
                .product(ProductBuilder.toProductDTO(shoppingCartProduct.getProduct()))
                .user(UserBuilder.toUserDTO(shoppingCartProduct.getUser()))
                .build();
    }

    public static List<ShoppingCartProductDTO> toShoppingCartProductDTOList(List<ShoppingCartProduct> shoppingCartProductList) {
        if (shoppingCartProductList == null || shoppingCartProductList.isEmpty()) {
            return Collections.emptyList();
        }

        return shoppingCartProductList.stream().map(s -> ShoppingCartProductBuilder.toShoppingCartProductDTO(s)).toList();
    }
}
