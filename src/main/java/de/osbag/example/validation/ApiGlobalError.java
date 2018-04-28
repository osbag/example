package de.osbag.example.validation;

/**
 * Created by bijan.zohouri on 4/24/2018.
 * this will be used as response for validation process
 */
public class ApiGlobalError {
    private String code;
    public ApiGlobalError(String code) {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
