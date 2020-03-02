/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.osbag.example.service;

import de.osbag.example.dto.UserResponse;
import de.osbag.example.entity.User;
import de.osbag.example.repository.UserRepository;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Eldin - unit test
 */
@RunWith(SpringRunner.class)
@ContextConfiguration
@DataJpaTest
public class UserServiceTest {
    
    private UserService userService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Before
    public void init(){
        userService = new UserService(userRepository);
    }
        
    @Test
    public void test() throws Exception {
        User user = new User();
        user.setDateOfBirth(LocalDate.parse("31.03.1985", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        user.setFirstName("Eldin");
        user.setLastName("Okanovic");
        user.setHeightInCm(170d);
        user.setWeightInKg(80d);
        userService.saveUser(user);          
        List<UserResponse> userResponses = userService.allUsers();         
        assertEquals("Number of users:", 1, userResponses.size());
        assertEquals("User name:", userResponses.get(0).getName(), "Eldin Okanovic");        
        assertEquals("User age:", userResponses.get(0).getAge().intValue(), Period.between(user.getDateOfBirth(), LocalDate.now()).getYears());
        assertEquals("User BMI:", userResponses.get(0).getBmi(), user.getWeightInKg() / ((user.getHeightInCm() / 100) * (user.getHeightInCm() / 100)));
    }
}
