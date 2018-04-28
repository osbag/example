package de.osbag.example.service;


import de.osbag.example.controller.UsersController;
import de.osbag.example.dto.UserRequestDto;
import de.osbag.example.dto.UserResponseDto;
import de.osbag.example.entity.User;
import de.osbag.example.repository.UserBaseRepository;
import de.osbag.example.utils.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bijan.zohouri on 4/24/2018.
 */
@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UserBaseRepository userBaseRepository;

    @Transactional
    public User saveUser(UserRequestDto dto) throws Exception {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDateOfBirth(dto.getDateOfBirth());
        user.setHeightInCm(dto.getHeightInCm());
        user.setWeightInKg(dto.getWeightInKg());
        Long userId = null;
        try {
            userId = userBaseRepository.save(user).getId();
        } catch (Exception e) {
            LOGGER.error(String.format("An error raised while saving the data"), e.getMessage());
            e.printStackTrace();
            throw new Exception("An error raised while saving the data");
        }
        user = userBaseRepository.FindOne(userId);
        if (user.equals(null)) {
            LOGGER.error(String.format("An error raised while saving the data"));
            throw new Exception("An error raised while saving the data");
        }
        return user;
    }

    public List<UserResponseDto> allUsers() throws Exception {
        List<UserResponseDto> userResponseDtos = new ArrayList<>();
        userBaseRepository.findAll().stream().forEach(user -> {
                    UserResponseDto userResponseDto = new UserResponseDto();
            try {
                userResponseDto.setBmi(Utility.calculateBmi(user.getWeightInKg(), user.getHeightInCm()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                userResponseDto.setAge(Utility.calculateAge(user.getDateOfBirth(), LocalDate.now()));
            } catch (Exception e) {
                e.printStackTrace();
            }
            userResponseDto.setId(user.getId());
                    userResponseDto.setName(user.getFirstName() + "-" + user.getLastName());
                    userResponseDtos.add(userResponseDto);
                }
        );
        return userResponseDtos;
    }


}
