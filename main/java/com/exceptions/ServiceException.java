package com.exceptions;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {

    private String code;
    public  ServiceException(String code,String msg){
        super(msg);
        this.code=code;
    }


}
