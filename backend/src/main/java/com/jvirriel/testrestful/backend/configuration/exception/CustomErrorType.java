package com.jvirriel.testrestful.backend.configuration.exception;


public class CustomErrorType {
    private Integer errorCode;
    private String errorMessage;

    private CustomErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    private CustomErrorType(Integer errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public static CustomErrorType get(String errorMessage) {
        return new CustomErrorType(errorMessage);
    }

    public static CustomErrorType get(Integer errorCode, String errorMessage) {
        return new CustomErrorType(errorCode, errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }
}
