package de.osbag.example.controller;


import de.osbag.example.dto.UserResponse;
import de.osbag.example.entity.User;
import de.osbag.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

        userService.saveUser(user);

        return ResponseEntity.created(null).build();
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<UserResponse>> allUsers() {

        return ResponseEntity.ok().body(userService.allUsers());
    }


}
