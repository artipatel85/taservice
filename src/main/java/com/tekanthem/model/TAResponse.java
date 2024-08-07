package com.tekanthem.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Getter @Setter
public class TAResponse {

    public TAResponse(Object responseData){
        this.responseData = responseData;
    }

    public TAResponse(Object responseData, String errorMessage,
                      String infoMessage, boolean isSuccess){
        this(responseData);
        this.errorMessage = errorMessage;
        this.infoMessage = infoMessage;
        if(isSuccess){
            this.status = "Success";
        }
        else{
            this.status = "Failed";
        }

    }

    private Object responseData;
    private String errorMessage;
    private String infoMessage;
    private String status;
}
