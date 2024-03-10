package com.example.MaxiPet.Repository;

import com.example.MaxiPet.Entity.ShoppingCartProduct;
import com.example.MaxiPet.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartProductRepository extends CrudRepository<ShoppingCartProduct, Integer> {
}
