package com.example.MaxiPet.Service;

import com.example.MaxiPet.DTO.AddShoppingCartProductToUserDTO;
import com.example.MaxiPet.DTO.Builders.ShoppingCartProductBuilder;
import com.example.MaxiPet.DTO.ShoppingCartProductDTO;
import com.example.MaxiPet.Entity.Product;
import com.example.MaxiPet.Entity.ShoppingCartProduct;
import com.example.MaxiPet.Entity.User;
import com.example.MaxiPet.Repository.ProductRepository;
import com.example.MaxiPet.Repository.ShoppingCartProductRepository;
import com.example.MaxiPet.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class ShoppingCartProductService {
    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ShoppingCartProductRepository shoppingCartProductRepository;

    public ShoppingCartProductDTO addProductToShoppingCartOfUser(AddShoppingCartProductToUserDTO addShoppingCartProductToUserDTO) throws Exception
    {
        Optional<User> optionalUser = userRepository.findById(addShoppingCartProductToUserDTO.getUser_id());
        if(optionalUser.isEmpty())
            throw new Exception("User not found");

        Optional<Product> optionalProduct = productRepository.findById(addShoppingCartProductToUserDTO.getProduct_id());
        if(optionalProduct.isEmpty())
            throw new Exception("Product not found");

        ShoppingCartProduct newShoppingCartProduct = ShoppingCartProduct.builder()
                .user(optionalUser.get())
                .product(optionalProduct.get())
                .quantity(addShoppingCartProductToUserDTO.getQuantity())
                .build();

        ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.save(newShoppingCartProduct);

        return ShoppingCartProductBuilder.toShoppingCartProductDTO(shoppingCartProduct);
    }
}
