package com.clumsycoder.controlshift.commons.exceptions;

import com.clumsycoder.controlshift.commons.constants.ExceptionMessageConstants;

public class GlobalException extends RuntimeException {

    public GlobalException() {
        super(ExceptionMessageConstants.UNEXPECTED_ERROR);
    }

    public GlobalException(String errorMessage) {
        super(errorMessage);
    }
}