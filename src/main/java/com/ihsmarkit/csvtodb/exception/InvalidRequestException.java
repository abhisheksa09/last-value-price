package com.ihsmarkit.csvtodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidRequestException extends RuntimeException {

	/**
     * Generated serial number
     */
    private static final long serialVersionUID = 2768298727672337948L;

    public InvalidRequestException(String message) {

	    super(message);
    }
}
