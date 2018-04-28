package de.osbag.example.controller;

/**
 * Created by bijan.zohouri on 4/24/2018.
 */

import de.osbag.example.validation.UserRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

public abstract class BaseController {

    @Autowired
    private UserRequestValidator userRequestValidator;

    public void setValidator(UserRequestValidator userRequestValidator) {
        this.userRequestValidator = userRequestValidator;
    }

    @InitBinder("userRequest")
    public void setupBinder(WebDataBinder binder) {
        binder.addValidators(userRequestValidator);
    }

}
