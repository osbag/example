package de.osbag.example.controller;

import de.osbag.example.dto.UserResponse;
import de.osbag.example.entity.User;
import de.osbag.example.service.UserService;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("api/v1")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<?> saveUser(@RequestBody User user) {       
        if (user != null) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<User>> constraints = validator.validate(user);
            if (constraints.isEmpty()) {
                userService.saveUser(user);
                return new ResponseEntity("User created", HttpStatus.CREATED);
            } else {
                String bodyHtml = "";
                for (ConstraintViolation<User> cv : constraints) {
                    bodyHtml += "Property " + cv.getPropertyPath() + " " + cv.getMessage() + "\n";
                }
                return new ResponseEntity<>(bodyHtml, HttpStatus.BAD_REQUEST);
            }
        } else {
            return new ResponseEntity<>("No valid JSON object found in request", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<UserResponse>> allUsers() {           
        return ResponseEntity.ok().body(userService.allUsers());
    }

}
