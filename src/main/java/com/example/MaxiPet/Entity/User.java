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

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ShoppingCartProduct> shoppingCartProductList;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<Order> orderList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Review> reviewList;
}
