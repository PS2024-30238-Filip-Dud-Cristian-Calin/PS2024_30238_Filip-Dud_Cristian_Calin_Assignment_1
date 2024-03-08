package com.example.MaxiPet.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String role;
    @Column
    private String name;
    @Column
    private String firstName;
    @Column
    private String email;
    @Column
    private String phone;
    @Column
    private String password;
    @OneToMany(mappedBy = "user")
    private List<ShoppingCartProduct> shoppingCartProductList;
    @OneToMany(mappedBy = "user")
    private List<Order> orderList;
    @OneToMany(mappedBy = "user")
    private List<Review> reviewList;
}
