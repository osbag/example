/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.osbag.example.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import de.osbag.example.entity.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Eldin
 */
public class Util {
    public static User createValidUser(){
        User user = new User();
        user.setDateOfBirth(LocalDate.parse("31.03.2020", DateTimeFormatter.ofPattern("dd.MM.yyyy")));
        user.setFirstName("Eldin");
        user.setLastName("Okanovic");
        user.setHeightInCm(170d);
        user.setWeightInKg(80d);
        return user;
    }
    public static String json(Object o) {
        ObjectMapper om = new ObjectMapper();
        om.registerModule(new JavaTimeModule());
        try {
            return om.writeValueAsString(o);
        } catch (Exception ex) {
            return null;
        }
    }
}
