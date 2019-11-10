package com.example.poll.exceptions;

public class BaseException extends RuntimeException {

    public BaseException(Exception e) {
        super(e);
    }

    public BaseException(String msg) {
        super(msg);
    }

    public BaseException(String format, Object... args) {
        super(String.format(format, args));
    }

    public BaseException(String message, Exception e) {
        super(message, e);
    }
}
