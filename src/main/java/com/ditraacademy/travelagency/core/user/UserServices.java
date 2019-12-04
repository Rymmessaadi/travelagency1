package com.ditraacademy.travelagency.core.user;

import com.ditraacademy.travelagency.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> createUser(User user) {

        if(user.getName() == null)
            return new ResponseEntity<>(new ErrorResponseModel("User name required"), HttpStatus.BAD_REQUEST);

        if(user.getName().length() < 3)
            return new ResponseEntity<>(new ErrorResponseModel("Wrong user name"), HttpStatus.BAD_REQUEST);

        if(user.getAge() == null)
            return new ResponseEntity<>(new ErrorResponseModel("User age required"), HttpStatus.BAD_REQUEST);

        if(user.getAge() <= 0)
            return new ResponseEntity<>(new ErrorResponseModel("Wrong user age"), HttpStatus.BAD_REQUEST);

        User databaseUser = userRepository.save(user);

        return new ResponseEntity<>(databaseUser, HttpStatus.OK);
    }
}
