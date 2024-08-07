package com.tekanthem.finance.service;

import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.entity.CompanyD;
import com.tekanthem.finance.exception.DuplicateRecordFoundException;

public interface CompanyService {

    CompanyD findByDescription(String description);

    void save(CompanyD company) throws DuplicateRecordFoundException;
}
