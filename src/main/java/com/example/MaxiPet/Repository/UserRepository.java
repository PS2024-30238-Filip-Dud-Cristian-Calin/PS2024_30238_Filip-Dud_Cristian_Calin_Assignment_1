package com.example.MaxiPet.Repository;

import com.example.MaxiPet.Entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>  {
    User getUserByEmailAndPassword(String email, String password);
}
