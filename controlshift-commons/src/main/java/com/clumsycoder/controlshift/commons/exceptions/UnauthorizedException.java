package com.clumsycoder.controlshift.commons.exceptions;

import com.clumsycoder.controlshift.commons.constants.ExceptionMessageConstants;

public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException() {
        super(ExceptionMessageConstants.UNAUTHORIZED_ERROR);
    }

    public UnauthorizedException(String errorMessage) {
        super(errorMessage);
    }
}