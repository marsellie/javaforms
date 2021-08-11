package com.kpfu.javaforms.exceptions;

import com.kpfu.javaforms.util.RestResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class AppExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public RestResponse handleAll(Exception e) {
        return RestResponse.fail(e.getMessage());
    }

    @ExceptionHandler(RestException.class)
    public RestResponse handleServiceException(RestException e) {
        return RestResponse.fail(e.getMessage());
    }
}
