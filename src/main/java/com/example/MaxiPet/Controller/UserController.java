package com.example.MaxiPet.Controller;

import com.example.MaxiPet.DTO.AddShoppingCartProductToUserDTO;
import com.example.MaxiPet.DTO.ShoppingCartProductDTO;
import com.example.MaxiPet.DTO.UserDTO;
import com.example.MaxiPet.Service.ShoppingCartProductService;
import com.example.MaxiPet.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@Validated
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;
    private final ShoppingCartProductService shoppingCartProductService;

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
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

    @PutMapping
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDTO userDTO) {

        try {
            UserDTO updatedUser = userService.updateUser(userDTO);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Integer userId) {
        try {
            UserDTO userDTO = userService.getUser(userId);
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

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
