package de.osbag.example.repository;

import de.osbag.example.controller.UsersController;
import de.osbag.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bijan.zohouri on 4/24/2018.
 *
 */
@Repository
public class UserBaseRepository {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    private UserJpaRepository jpaRepository;


    public List<User> findAll() {
        return jpaRepository.findAll();
    }

    public User save(User newUser) {
        User newEntity = new User(newUser);
        try {
            newEntity =  jpaRepository.save(newEntity);
        } catch (Exception e) {
            LOGGER.error(String.format("An error raised while saving the data"), e.getMessage());
            e.printStackTrace();
        }
        return newEntity;
    }

    public User FindOne(Long id) {
        return jpaRepository.getOne(id);
    }
}
