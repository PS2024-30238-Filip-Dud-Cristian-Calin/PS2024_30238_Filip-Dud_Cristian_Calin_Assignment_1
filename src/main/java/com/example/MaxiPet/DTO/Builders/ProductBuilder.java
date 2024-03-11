package com.example.MaxiPet.DTO.Builders;

import com.example.MaxiPet.DTO.ProductDTO;
import com.example.MaxiPet.Entity.Product;

public class ProductBuilder {

    public static ProductDTO toProductDTO(Product product){
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .category(product.getCategory())
                .shoppingCartProductDTOList(ShoppingCartProductBuilder.toShoppingCartProductDTOList(product.getShoppingCartProductList()))
                .orderProductDTOList(OrderProductBuilder.toOrderProductDTOList(product.getOrderProductList()))
                .reviewDTOList(ReviewBuilder.toReviewDTOList(product.getReviewList()))
                .build();
    }
    public static Product toEntity(ProductDTO productDTO) {
        return Product.builder()
                .id(productDTO.getId())
                .name(productDTO.getName())
                .price(productDTO.getPrice())
                .stock(productDTO.getStock())
                .category(productDTO.getCategory())
                .build();
    }
}
