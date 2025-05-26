package com.clumsycoder.controlshift.commons.exceptions;

import com.clumsycoder.controlshift.commons.constants.ExceptionMessageConstants;

public class ResourceNotFoundException extends GlobalException {
    public ResourceNotFoundException() {
        super(ExceptionMessageConstants.RESOURCE_NOT_FOUND_ERROR);
    }

    public ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}