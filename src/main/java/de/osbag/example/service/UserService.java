package de.osbag.example.service;

import de.osbag.example.dto.UserResponse;
import de.osbag.example.entity.User;
import de.osbag.example.repository.UserRepository;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {

        // TODO:
        userRepository.saveAndFlush(user);        
    }

    public List<UserResponse> allUsers() {

        // TODO: return a list of UserResponse structure with calculated bmi and age.
        List<User> allUsers = userRepository.findAll();
        List<UserResponse> resultList = new LinkedList<>();
        for (User u : allUsers) {
            UserResponse ur = new UserResponse();
            ur.setId(u.getId());
            ur.setBmi(calculateBmi(u));
            ur.setAge(extractUserAge(u));
            ur.setName(buildNameValue(u));
            resultList.add(ur);
        }
        return resultList;
    }
        
    private String buildNameValue(final User u) {
        return u.getFirstName() + " " + u.getLastName();
    }

    private Integer extractUserAge(final User pUser) {
        return pUser.getDateOfBirth() == null ? null : Period.between(pUser.getDateOfBirth(), LocalDate.now()).getYears();
    }

    private double calculateBmi(final User pUser) {
        return pUser.getWeightInKg() / ((pUser.getHeightInCm() / 100) * (pUser.getHeightInCm() / 100));
    }

}
