package de.osbag.example.utils;

import de.osbag.example.controller.UsersController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;

/**
 * Created by bijan.zohouri on 4/24/2018.
 */

public class Utility {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    public static Double calculateBmi(double weight, double height) throws Exception {
        // bmi = (weight-in-kg) / (height-in-meters) * (height-in-meters)
        Double bmi = 0.0;
        try {
            bmi = (weight / (height / 100)) * height;
        } catch (Exception e) {
            LOGGER.error(String.format("An error raised while calculating the bmi"), e.getMessage());
            e.printStackTrace();
            throw new Exception("An error raised while calculating the bmi");
        }
        return bmi;
    }

    public static Integer calculateAge(LocalDate birthDate, LocalDate currentDate) throws Exception {
        try {
            if ((birthDate != null) && (currentDate != null)) {
                return Period.between(birthDate, currentDate).getYears();
            } else {
                throw new Exception("There is a validation error on data Input");
            }
        } catch (Exception e) {
            LOGGER.error(String.format("An error raised while calculating the age"), e.getMessage());
            e.printStackTrace();
            throw new Exception("An error raised while calculating the age");
        }
    }
}
