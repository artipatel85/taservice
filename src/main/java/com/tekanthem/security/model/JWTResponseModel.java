package com.tekanthem.security.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JWTResponseModel {
    private String token;

    public JWTResponseModel(String jwtToken) {
        this.token = jwtToken;
    }
}
