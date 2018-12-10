package com.gsuero.data;

import java.io.Serializable;

public class ErrorResult implements Serializable {
    private static final long serialVersionUID = -2088175484854827077L;
    private ErrorType type;
    private String property;
    private String message;
    
    public ErrorResult(ErrorType type, String property, String message) {
        super();
        this.type = type;
        this.property = property;
        this.message = message;
    }
    
    public ErrorType getType() {
        return type;
    }
    public void setType(ErrorType type) {
        this.type = type;
    }
    public String getProperty() {
        return property;
    }
    public void setProperty(String property) {
        this.property = property;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    
}
