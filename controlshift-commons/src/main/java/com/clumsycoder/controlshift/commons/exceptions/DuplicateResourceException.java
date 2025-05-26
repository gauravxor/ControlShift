package com.clumsycoder.controlshift.commons.exceptions;

import com.clumsycoder.controlshift.commons.constants.ExceptionMessageConstants;

public class DuplicateResourceException extends GlobalException{
    public DuplicateResourceException() {
        super(ExceptionMessageConstants.DUPLICATE_RESOURCE_ERROR);
    }

    public DuplicateResourceException(String errorMessage) {
        super(errorMessage);
    }

}