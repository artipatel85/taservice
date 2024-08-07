package com.tekanthem.security.controller;

import com.tekanthem.finance.entity.UserD;
import com.tekanthem.finance.service.impl.UserInfoServiceImpl;
import com.tekanthem.model.TAResponse;
import com.tekanthem.security.JwtService;
import com.tekanthem.security.model.JWTRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/auth")
public class JWTController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserInfoServiceImpl userInfoService;

    @PostMapping("/login")
    public ResponseEntity<TAResponse> createToken(@RequestBody JWTRequestModel
                                                request) throws Exception {
        UserD user = userInfoService.findByUserName(request.getUserName());
        if(user == null  || !request.getPassword().equals(user.getPassword())){
            String errorMsg = "INVALID_CREDENTIALS";
            return new ResponseEntity<>(new TAResponse(null, errorMsg,
                    null, false),
                    HttpStatus.UNAUTHORIZED);
        }
        if(!"A".equalsIgnoreCase(user.getStatus())){
            String errorMsg = "User is not active.";
            return new ResponseEntity<>(new TAResponse(null, errorMsg,
                    null, false),
                    HttpStatus.UNAUTHORIZED);
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("isAdmin", false);
        claims.put("role", user.getRole());

        final String jwtToken = jwtService.generateToken(user.getUserName(), claims);
        String infoMsg  = "Login successfully.";
        return new ResponseEntity<>(new TAResponse(jwtToken, null,
                infoMsg, true),
                HttpStatus.UNAUTHORIZED);
    }
}
