package com.capstone.project.common.exception;

import com.capstone.project.common.response.ApiResponse;
import com.capstone.project.common.response.Constants;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = LoginException.class)
    public ApiResponse<LoginException> loginExceptionHandler(LoginException e) {
        ApiResponse response = new ApiResponse();
        response.getMeta().put(Constants.Key.CODE.getKey(), Constants.Code.FAIL.getCode());
        response.getMeta().put(Constants.Key.MESSAGE.getKey(), Constants.Code.FAIL.getMessage());

        response.getData().add(e);
        return response;
    }

    @ExceptionHandler(value = HttpClientErrorException.class)
    public ApiResponse<LoginException> httpClientErrorException(HttpClientErrorException e) {
        ApiResponse response = new ApiResponse();
        response.getMeta().put(Constants.Key.CODE.getKey(), Constants.Code.FAIL.getCode());
        response.getMeta().put(Constants.Key.MESSAGE.getKey(), Constants.Code.FAIL.getMessage());

        response.getData().add(e);
        return response;
    }

}
