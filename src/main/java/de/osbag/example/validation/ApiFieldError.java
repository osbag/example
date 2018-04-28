package de.osbag.example.validation;

/**
 * Created by bijan.zohouri on 4/24/2018.
 * this will be used as a response for validation process
 */
public class ApiFieldError {
    private String field;
    private String code;
    private Object rejectedValue;

    public ApiFieldError(String field, String code, Object rejectedValue) {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
