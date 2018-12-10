package com.gsuero.data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gsuero
 */
public class ValidationError {

    private List<ErrorResult> errors = new ArrayList<>();

    public List<ErrorResult> getErrors() {
        return errors;
    }

    public void add(ErrorType type, String property, String message) {
        errors.add(new ErrorResult(type, property, message));
    }

    public boolean isValid() {
        return errors.isEmpty();
    }
}
