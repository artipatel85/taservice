package com.tekanthem.security.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JWTRequestModel {

    private String userName;
    private String password;
}
