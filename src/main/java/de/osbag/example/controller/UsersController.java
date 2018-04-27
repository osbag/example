package de.osbag.example.controller;


import de.osbag.example.dto.UserRequestDto;
import de.osbag.example.dto.UserResponseDto;
import de.osbag.example.entity.User;
import de.osbag.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bijan.zohouri on 4/24/2018.
 */

@RestController
@RequestMapping("api/v1")
public class UsersController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public ResponseEntity<?> saveUser(@RequestBody @Valid UserRequestDto userRequestDto) throws Exception {
        try {
            LOGGER.info("URL=/users, POST, UserRequestDto:" + userRequestDto.toString());
            User user = userService.saveUser(userRequestDto);
            LOGGER.info("Response Model:" + user.toString());
        } catch (Exception e) {
            LOGGER.error(String.format("An error raised while saving the data"), e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    public ResponseEntity<List<UserResponseDto>> allUsers() throws Exception {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        try {
                userResponseDtos.add((UserResponseDto) userService.allUsers());
        } catch (Exception e) {
            LOGGER.error(String.format("An error raised while fetching the data"), e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return ResponseEntity.ok().body(userResponseDtos);
    }


}
