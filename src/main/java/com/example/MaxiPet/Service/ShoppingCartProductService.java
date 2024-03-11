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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class ShoppingCartProductService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ShoppingCartProductRepository shoppingCartProductRepository;


    @Autowired
    public ShoppingCartProductService(UserRepository userRepository, ProductRepository productRepository,ShoppingCartProductRepository shoppingCartProductRepository)
    {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.shoppingCartProductRepository = shoppingCartProductRepository;
    }
    /**
     *
     * @param addShoppingCartProductToUserDTO the dto that contains the id of the user, the id of the product and the quantity
     * @return the dto of the product from the shopping cart
     * @throws Exception if the user or the product id are not found
     */
    public ShoppingCartProductDTO addProductToShoppingCartOfUser(AddShoppingCartProductToUserDTO addShoppingCartProductToUserDTO) throws Exception
    {
        Optional<User> optionalUser = userRepository.findById(addShoppingCartProductToUserDTO.getUserId());
        if(optionalUser.isEmpty()) {
            log.warn("The product with id {} was not found in the DB!", addShoppingCartProductToUserDTO.getUserId());
            throw new Exception("User not found");
        }

        Optional<Product> optionalProduct = productRepository.findById(addShoppingCartProductToUserDTO.getProductId());
        if(optionalProduct.isEmpty()) {
            log.warn("The product with id {} was not found in the DB!", addShoppingCartProductToUserDTO.getProductId());
            throw new Exception("Product not found");
        }
        ShoppingCartProduct newShoppingCartProduct = ShoppingCartProduct.builder()
                .user(optionalUser.get())
                .product(optionalProduct.get())
                .quantity(addShoppingCartProductToUserDTO.getQuantity())
                .build();

        ShoppingCartProduct shoppingCartProduct = shoppingCartProductRepository.save(newShoppingCartProduct);

        return ShoppingCartProductBuilder.toShoppingCartProductDTO(shoppingCartProduct);
    }
}
