package fintech.test.application.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            errors.putIfAbsent(fieldError.getField() + "Error", fieldError.getDefaultMessage());
        }
        return errors;
    }

    public static Boolean isAuthentication(){
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return  !(authentication == null || "anonymousUser".equals(authentication.getPrincipal()));
    }
}