package com.seef.diag.commons;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

import static javax.validation.Validation.buildDefaultValidatorFactory;

public abstract class ModelValidator {
    private final Validator validator;

    public ModelValidator() {
        this.validator = buildDefaultValidatorFactory().getValidator();
    }

    protected void validate(){
        Set<ConstraintViolation<ModelValidator>> violations = validator.validate(this);
        violations.forEach(constraint -> {throw new IllegalArgumentException(constraint.getMessage());});
    }

    protected void validateProperty(String property){
        Set<ConstraintViolation<ModelValidator>> violations = validator.validateProperty(this, property);
        violations.forEach(constraint -> {throw new IllegalArgumentException(constraint.getMessage());});
    }
}
