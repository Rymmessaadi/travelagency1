package com.ditraacademy.travelagency.core.user;

import com.ditraacademy.travelagency.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServices userServices;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return userServices.createUser(user);
    }

    @GetMapping("/users")
    public List<User> getAllUsers () {
        List<User> userList = userRepository.findAll();
        return  userList;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUserById (@PathVariable int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Wrong user Id");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        User user = userOptional.get();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody User updatedUser) {

        Optional<User> userOptional = userRepository.findById(id);

        if(!userOptional.isPresent()) {
            ErrorResponseModel errorResponseModel = new ErrorResponseModel("Wrong user Id");
            return new ResponseEntity<>(errorResponseModel, HttpStatus.BAD_REQUEST);
        }

        User databaseUser = userOptional.get();

        if(updatedUser.getName() != null) {
            if(updatedUser.getName().length() < 3) {
                return new ResponseEntity<>(new ErrorResponseModel("Wrong user name"), HttpStatus.BAD_REQUEST);
            }
            databaseUser.setName(updatedUser.getName());
        }

        if(updatedUser.getAge() != null) {
            if(updatedUser.getAge() < 0) {
                return new ResponseEntity<>(new ErrorResponseModel("Wrong user age"), HttpStatus.BAD_REQUEST);
            }
            databaseUser.setAge(updatedUser.getAge());
        }

        userRepository.save(databaseUser);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
