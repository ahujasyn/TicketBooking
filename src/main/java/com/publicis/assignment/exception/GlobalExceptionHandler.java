package com.publicis.assignment.exception;

import com.publicis.assignment.dto.ResponseDto.ServiceResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SeatsNotAvailableException.class)
    public  ResponseEntity<ServiceResponse<String>>  handleSeatsNotAvailableException(SeatsNotAvailableException ex) {
        return  new ResponseEntity<>(getServiceResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public  static ServiceResponse<String> getServiceResponse(int status,String message) {
        ServiceResponse<String> resp = new ServiceResponse<>();
        resp.setStatus(status);
        resp.setData(message);
        return resp;
    }
}