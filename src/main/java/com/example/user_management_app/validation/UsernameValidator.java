package com.example.user_management_app.validation;

import com.example.user_management_app.dto.ValidUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<ValidUsername, String> {

    @Override
    public void initialize(ValidUsername constraintAnnotation) {
        // Initialization code if needed (not required for basic validation)
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        // Validation logic: Ensures the username follows a specific pattern
        return username != null && username.matches("^[a-zA-Z0-9._-]{3,}$");
    }
}



