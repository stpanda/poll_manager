package com.example.poll.rest.controller;

import com.example.poll.exceptions.ResourceNotFoundException;
import com.example.poll.rest.BaseResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class BaseController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public BaseResponse handleResourceNotFound(ResourceNotFoundException e) {
        return BaseResponse.buildErrorResponse(404, e);
    }

}
