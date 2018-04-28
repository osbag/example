package de.osbag.example.validation;

import de.osbag.example.dto.UserRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;

/**
 * Created by bijan.zohouri on 4/24/2018.
 * This a validator class to validate the user inputs
 * however the code can be improved by adding the complete implementation of
 * Spring Annotation validation. Right now I just added some sample code structure to show its pattern
 */
@Component
public class UserRequestValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return UserRequestDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserRequestDto userRequestDto = (UserRequestDto) target;

        if (userRequestDto.getFirstName().isEmpty()) {
            errors.reject("first name can not be null");
        }
        else if (userRequestDto.getFirstName().length() > 30) {
            errors.reject("First name must be max 30 chars");
        }
        else if (userRequestDto.getLastName().isEmpty()) {
            errors.reject("Last name can not be null");
        }
        else if (userRequestDto.getLastName().length() > 30) {
            errors.reject("Last name must be max 30 chars");
        }
        else if (userRequestDto.getHeightInCm().equals(null) || userRequestDto.getHeightInCm() == 0) {
            errors.reject("Height must not be null or zero");
        }
        else if (userRequestDto.getHeightInCm() > 1000) {
            errors.reject("Height can be max 3 digits");
        }
        else if (userRequestDto.getWeightInKg() > 1000) {
            errors.reject("Weight can be max 3 digits");
        }
        else if (userRequestDto.getWeightInKg().equals(null) || userRequestDto.getHeightInCm() == 0) {
            errors.reject("Weight must not be null or zero");
        }
        else if (userRequestDto.getDateOfBirth().isEqual(null)) {
            errors.reject("Date Of birth must not be null or zero");
        }
        else if (userRequestDto.getDateOfBirth().isAfter(LocalDate.now()) ||
                (userRequestDto.getDateOfBirth().toString().length() != 10)) {
            errors.reject("Date Of birth is invalid");
        }
    }
}
