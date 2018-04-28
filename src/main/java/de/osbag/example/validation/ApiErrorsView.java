package de.osbag.example.validation;

import java.util.List;

/**
 * Created by bijan.zohouri on 4/24/2018.
 * This will be used as model in response for validaitons
 */
public class ApiErrorsView {
    private List<ApiFieldError> fieldErrors;
    private List<ApiGlobalError> globalErrors;
    public ApiErrorsView(List<ApiFieldError> apiFieldErrors, List<ApiGlobalError> apiGlobalErrors) {
    }

    public List<ApiFieldError> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(List<ApiFieldError> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
