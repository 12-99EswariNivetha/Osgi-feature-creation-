package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;

public class IdAlreadyFoundException extends CustomException {
    public IdAlreadyFoundException(String msg) {
        super(msg);
    }
}
