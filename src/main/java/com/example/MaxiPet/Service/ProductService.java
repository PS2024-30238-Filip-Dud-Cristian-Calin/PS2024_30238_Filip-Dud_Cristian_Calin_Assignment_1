package com.example.MaxiPet.Service;

import com.example.MaxiPet.DTO.Builders.ProductBuilder;
import com.example.MaxiPet.DTO.Builders.UserBuilder;
import com.example.MaxiPet.DTO.ProductDTO;
import com.example.MaxiPet.DTO.UserDTO;
import com.example.MaxiPet.Entity.Product;
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
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }

    /**
     *
     * @param productDTO The ProductDTO containing information about the product to be created.
     * @return A ProductDTO representing the newly created product.
     */
    public ProductDTO createProduct(ProductDTO productDTO)
    {
        Product product = productRepository.save(ProductBuilder.toEntity(productDTO));
        return ProductBuilder.toProductDTO(product);
    }

    /**
     *
     * @param productDTO contains the product of the user to be updated
     * @return the productDTO of the updated product entity
     * @throws Exception if the product is not found
     */
    public ProductDTO updateProduct(ProductDTO productDTO) throws Exception {
        Optional<Product> optionalProduct = productRepository.findById(productDTO.getId());
        if(optionalProduct.isEmpty()) {
            log.warn("The product with id {} was not found in the DB!", productDTO.getId());

            throw new Exception("Product not found");
        }

        Product product = optionalProduct.get();

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());

        Product updatedProduct = productRepository.save(product);

        return ProductBuilder.toProductDTO(updatedProduct);
    }

    /**
     *
     * @param productId  contains the id of the product to be retrieved
     * @return the productDTO of the retrieved product entity
     * @throws Exception if the product is not found
     */
    public ProductDTO getProduct(Integer productId) throws Exception {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()) {
            log.warn("The product with id {} was not found in the DB!", productId);

            throw new Exception("Product not found");
        }

        return ProductBuilder.toProductDTO(product.get());
    }

    /**
     *
     * @param productId the id of the product to be deleted
     * @throws Exception if the product is not found
     */
    public void deleteProduct(Integer productId) throws Exception {
        Optional<Product> product = productRepository.findById(productId);
        if(product.isEmpty()) {
            log.warn("The product with id {} was not found in the DB!", productId);

            throw new Exception("Product not found");
        }
        productRepository.deleteById(productId);
    }
}
