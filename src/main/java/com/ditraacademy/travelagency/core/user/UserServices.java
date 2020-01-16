package com.ditraacademy.travelagency.core.user;

import com.ditraacademy.travelagency.utils.ErrorResponseModel;
import com.ditraacademy.travelagency.utils.Mailer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServices {

    @Autowired
    UserRepository userRepository;
    @Autowired
    Mailer mailer;

    public ResponseEntity<?> createUser(User user) {

        if(user.getName() == null)
            return new ResponseEntity<>(new ErrorResponseModel("User name required"), HttpStatus.BAD_REQUEST);

        if(user.getName().length() < 3)
            return new ResponseEntity<>(new ErrorResponseModel("Wrong user name"), HttpStatus.BAD_REQUEST);

        if(user.getAge() == null)
            return new ResponseEntity<>(new ErrorResponseModel("User age required"), HttpStatus.BAD_REQUEST);

        if(user.getAge() <= 0)
            return new ResponseEntity<>(new ErrorResponseModel("Wrong user age"), HttpStatus.BAD_REQUEST);

        String destination = user.getEmail();
      String subject = "Welcome";
      String  text = "Rim HiBA";
      mailer.sendEmail(destination, subject, text);
        User databaseUser = userRepository.save(user);

        return new ResponseEntity<>(databaseUser, HttpStatus.OK);
    }
}
