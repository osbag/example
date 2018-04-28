package de.osbag.example.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import de.osbag.example.utils.LocalDateDeserializer;
import de.osbag.example.utils.LocalDateSerializer;

import java.time.LocalDate;

/**
 * Created by bijan.zohouri on 4/24/2018.
 * A dto has been created for the sake of in transition operations
 */
public class UserRequestDto {


    private String firstName;
    private String lastName;
    private Double weightInKg;
    private Double heightInCm;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate dateOfBirth;

    public UserRequestDto(String firstName, String lastName, Double weightInKg, Double heightInCm, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.heightInCm = heightInCm;
        this.weightInKg = weightInKg;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Double getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(Double weightInKg) {
        this.weightInKg = weightInKg;
    }

    public Double getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(Double heightInCm) {
        this.heightInCm = heightInCm;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "firstName=" + firstName +
                " lastName=" + lastName +
                " weightInKg=" + weightInKg +
                " heightInCm=" + heightInCm +
                " dateOfBirth=" + dateOfBirth;
    }
}
