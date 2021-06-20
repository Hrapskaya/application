package fintech.test.application.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ControllerUtil {

    static Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String, String> errors = new HashMap<>();
        List<FieldError> errorList = bindingResult.getFieldErrors();
        for (FieldError fieldError : errorList) {
            errors.put(fieldError.getField() + "Error", fieldError.getDefaultMessage());
        }
        return errors;
    }
}