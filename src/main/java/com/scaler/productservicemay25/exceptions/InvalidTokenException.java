package com.scaler.productservicemay25.exceptions;

//public class UnauthorizedException extends RuntimeException {
//    public UnauthorizedException(String message) {
//        super(message);
//    }
//}

public class InvalidTokenException extends RuntimeException{
    private String message;
    public InvalidTokenException(String message) {
        super(message);
        this.message= message;
    }
}