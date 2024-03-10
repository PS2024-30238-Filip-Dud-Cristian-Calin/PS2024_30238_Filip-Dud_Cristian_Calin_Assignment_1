package com.example.MaxiPet.DTO;

import com.example.MaxiPet.Entity.Order;
import com.example.MaxiPet.Entity.Product;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderProductDTO {

    private Order order;
    private Product product;
    private Integer quantity;
}
