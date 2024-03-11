package com.example.MaxiPet.Controller;

import com.example.MaxiPet.DTO.AddShoppingCartProductToUserDTO;
import com.example.MaxiPet.DTO.ShoppingCartProductDTO;
import com.example.MaxiPet.DTO.UserDTO;
import com.example.MaxiPet.Repository.ProductRepository;
import com.example.MaxiPet.Repository.ShoppingCartProductRepository;
import com.example.MaxiPet.Repository.UserRepository;
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
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final ShoppingCartProductService shoppingCartProductService;

    @Autowired
    public UserController(UserService userService, ShoppingCartProductService shoppingCartProductService)
    {
        this.shoppingCartProductService = shoppingCartProductService;
        this.userService = userService;
    }

    /**
     *
     * @param userDTO the dto of the user to be created
     * @return ResponseEntity containing the created UserDTO with HTTP status code 201 (Created) if successful.
     */
    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    /**
     *
     * @param addShoppingCartProductToUserDTO contains the data required to add a product to a users shopping cart
     * @return ResponseEntity containing the added ShoppingCartProductDTO with HTTP status code 201 (Created) if successful,
     *         or HTTP status code 400 (Bad Request) otherwise.
     */
    @PostMapping(value = "/cartproduct")
    public ResponseEntity<?> addShoppingCartProduct(@Valid @RequestBody AddShoppingCartProductToUserDTO addShoppingCartProductToUserDTO) {
        try {
            ShoppingCartProductDTO shoppingCartProductDTO = shoppingCartProductService.addProductToShoppingCartOfUser(addShoppingCartProductToUserDTO);
            return new ResponseEntity<>(shoppingCartProductDTO, HttpStatus.CREATED);
        }catch (Exception e)
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    /**
     *
     * @param userDTO contains the data required to update the user information
     * @return ResponseEntity containing the updated UserDTO with HTTP status code 200 (OK) if successful
     *         or HTTP status code 400 (Bad Request) otherwise.
     */
    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDTO userDTO) {

        try {
            UserDTO updatedUser = userService.updateUser(userDTO);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    /**
     *
     * @param userId contains the id of the user to be retrieved
     * @return ResponseEntity containing the UserDTO with HTTP status code 200 (OK) if the user is found
     *         or HTTP status code 400 (Bad Request) otherwise.
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer userId) {
        try {
            UserDTO userDTO = userService.getUser(userId);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    /**
     *
     * @param userId contains the id of the user to be deleted
     * @return ResponseEntity with HTTP status code 200 (OK) if the user is successfully deleted
     *          or HTTP status code 400 (Bad Request) otherwise.
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer userId) {
        try {
            userService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
