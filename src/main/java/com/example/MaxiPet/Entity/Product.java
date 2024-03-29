package com.example.MaxiPet.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
    @Column
    private Float price;
    @Column
    private Integer stock;
    @Column
    private String category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<ShoppingCartProduct> shoppingCartProductList;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private List<OrderProduct> orderProductList;

    @OneToMany(mappedBy = "product", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Review> reviewList;
}
