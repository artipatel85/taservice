package com.tekanthem.finance.service;

import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.exception.DuplicateRecordFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface COAService {
    public COA saveCOA(COA coa) throws DuplicateRecordFoundException;

    Page<COA> findAllByPage(Pageable paging);

    COA findByAccountCode(int accountCode, int companyCode);
}
