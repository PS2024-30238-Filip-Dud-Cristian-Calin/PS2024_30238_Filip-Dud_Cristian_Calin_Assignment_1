package com.example.MaxiPet.Service;

import com.example.MaxiPet.DTO.Builders.UserBuilder;
import com.example.MaxiPet.DTO.UserDTO;
import com.example.MaxiPet.Entity.User;
import com.example.MaxiPet.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class UserService {

    private final UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user = userRepository.save(UserBuilder.toEntity(userDTO));
        return UserBuilder.toUserDTO(user);
    }

    public UserDTO updateUser(UserDTO userDTO) throws Exception {
        Optional<User> optionalUser = userRepository.findById(userDTO.getId());
        if(optionalUser.isEmpty()) {
            log.warn("The user with id {} was not found in the DB!", userDTO.getId());

            throw new Exception("User not found");
        }

        User user = optionalUser.get();

        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());

        User updatedUser = userRepository.save(user);

        return UserBuilder.toUserDTO(updatedUser);
    }


    public UserDTO getUser(Integer userId) throws Exception {
        Optional<User> user = userRepository.findById(userId);
        if(user.isEmpty()) {
            log.warn("The user with id {} was not found in the DB!", userId);

            throw new Exception("User not found");
        }

        return UserBuilder.toUserDTO(user.get());
    }

    public void deleteUser(Integer userId) throws Exception {
        userRepository.deleteById(userId);
    }
}
