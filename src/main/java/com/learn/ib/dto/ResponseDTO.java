package com.learn.ib.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDTO<T> {

    private HttpStatus statusCode;

    private T data;

    public ResponseDTO(HttpStatus httpStatus, T data){

        this.statusCode = httpStatus;
        this.data = data;
    }



}
