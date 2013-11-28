package com.oclock.exceptions;


public class ApiException extends Exception {
    public ApiException() {
    }

    public ApiException(String detailMessage) {
        super(detailMessage);
    }

    public ApiException(Throwable throwable) {
        super(throwable);
    }

    public ApiException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
