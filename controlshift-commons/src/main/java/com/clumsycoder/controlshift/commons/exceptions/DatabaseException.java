package com.clumsycoder.controlshift.commons.exceptions;

import com.clumsycoder.controlshift.commons.constants.ExceptionMessageConstants;

public class DatabaseException extends GlobalException {
    public DatabaseException() {
        super(ExceptionMessageConstants.DATABASE_OPERATION_ERROR);
    }

    public DatabaseException(String errorMessage) {
        super(errorMessage);
    }
}