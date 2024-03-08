package com.example.MaxiPet.DTO.Builders;

import com.example.MaxiPet.DTO.OrderDTO;
import com.example.MaxiPet.Entity.Order;

import java.util.Collections;
import java.util.List;

public class OrderBuilder {

    public static OrderDTO toOrderDTO(Order order) {
        return OrderDTO.builder()
                .build();
    }

    public static List<OrderDTO> toOrderDTOList(List<Order> orderList) {
        if (orderList == null || orderList.isEmpty()) {
            return Collections.emptyList();
        }
        return orderList.stream().map(o -> OrderBuilder.toOrderDTO(o)).toList();
    }
}
