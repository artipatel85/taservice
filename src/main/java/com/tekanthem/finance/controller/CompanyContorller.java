package com.tekanthem.finance.controller;

import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.entity.CompanyD;
import com.tekanthem.finance.exception.DuplicateRecordFoundException;
import com.tekanthem.finance.service.CompanyService;
import com.tekanthem.model.TAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/company")
public class CompanyContorller {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody CompanyD company){
        try {
            companyService.save(company);
        } catch (DuplicateRecordFoundException e) {
            return new ResponseEntity(new TAResponse(null, "Duplicate Account Record.", null, false),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        String infoMsg = "Company created Successfully!";
        return new ResponseEntity(new TAResponse(company, null, infoMsg, true), HttpStatus.OK);
    }
}
