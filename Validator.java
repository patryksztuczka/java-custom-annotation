package com.application.lab5;

public interface Validator {
    void validate(String value);
    boolean isValid();
    String getMessage();
}
