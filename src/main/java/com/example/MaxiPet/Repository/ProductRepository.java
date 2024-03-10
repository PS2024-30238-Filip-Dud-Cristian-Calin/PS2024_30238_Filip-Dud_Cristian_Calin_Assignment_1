package com.example.MaxiPet.Repository;

import com.example.MaxiPet.Entity.Product;
import com.example.MaxiPet.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
    Product getProductsByCategory(String category);
}
