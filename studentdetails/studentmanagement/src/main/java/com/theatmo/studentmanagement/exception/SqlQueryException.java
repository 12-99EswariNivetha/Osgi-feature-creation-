package com.theatmo.studentmanagement.exception;

import com.theatmo.customexception.exception.CustomException;

public class SqlQueryException extends CustomException {
    public SqlQueryException(String msg) {
        super(msg);
    }
}
