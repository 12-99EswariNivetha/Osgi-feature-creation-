package com.theatmo.databaseconnection.exception;

import com.theatmo.customexception.exception.CustomException;

public class ConnectionFailedException extends CustomException {

        public ConnectionFailedException(String msg) {
            super(msg);
        }
    }

