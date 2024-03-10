package com.example.MaxiPet.DTO;

import com.example.MaxiPet.Entity.OrderProduct;
import com.example.MaxiPet.Entity.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
@Builder
public class OrderDTO {

    private Integer id;
    private String status;
    private Date orderDate;
    private Float totalPrice;
    private List<OrderProductDTO> orderProductDTOList;
    private Integer userId;
}
