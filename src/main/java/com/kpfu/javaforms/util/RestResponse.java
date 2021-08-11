package com.kpfu.javaforms.util;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

public class RestResponse extends ResponseEntity<HashMap<String, Object>> {

    public RestResponse(String errorMessage, Object data, HttpStatus status) {
        super(createBody(errorMessage, data), status);
    }

    public static RestResponse okResponse(){
        return okResponse("");
    }

    public static RestResponse okResponse(Object data){
        return new RestResponse("", data, HttpStatus.OK);
    }

    public static RestResponse fail(String message) {
        return new RestResponse(message, "", HttpStatus.BAD_REQUEST);
    }

    private static HashMap<String, Object> createBody(String errorMessage, Object data){
        HashMap<String, Object> map = new HashMap<>();
        map.put("errorMessage", errorMessage);
        map.put("data", data);
        return map;
    }
}
