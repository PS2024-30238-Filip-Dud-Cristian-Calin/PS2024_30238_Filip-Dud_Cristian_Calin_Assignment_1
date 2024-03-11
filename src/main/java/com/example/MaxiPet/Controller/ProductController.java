package com.example.MaxiPet.Controller;

import com.example.MaxiPet.DTO.ProductDTO;
import com.example.MaxiPet.DTO.UserDTO;
import com.example.MaxiPet.Service.ProductService;
import com.example.MaxiPet.Service.ShoppingCartProductService;
import com.example.MaxiPet.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Validated
@RequestMapping(value = "/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }

    /**
     *
     * @param productDTO the dto of the product to be created
     * @return ResponseEntity containing the created ProductDTO with HTTP status code 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductDTO createdProduct = productService.createProduct(productDTO);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }

    /**
     *
     * @param productDTO contains the data required to update the product information
     * @return ResponseEntity containing the updated ProductDTO with HTTP status code 200 (OK) if successful
     *         or HTTP status code 400 (Bad Request) otherwise.
     */
    @PutMapping
    public ResponseEntity<?> updateProduct(@Valid @RequestBody ProductDTO productDTO) {

        try {
            ProductDTO updatedProduct = productService.updateProduct(productDTO);
            return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     * @param productId contains the id of the product to be retrieved
     * @return ResponseEntity containing the ProductDTO with HTTP status code 200 (OK) if the product is found
     *         or HTTP status code 400 (Bad Request) otherwise.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Integer productId) {
        try {
            ProductDTO productDTO = productService.getProduct(productId);
            return new ResponseEntity<>(productDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     * @param productId contains the id of the product to be deleted
     * @return ResponseEntity with HTTP status code 200 (OK) if the product is successfully deleted
     *         or HTTP status code 400 (Bad Request) otherwise.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer productId) {
        try {
            productService.deleteProduct(productId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
