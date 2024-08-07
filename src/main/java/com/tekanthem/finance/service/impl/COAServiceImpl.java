package com.tekanthem.finance.service.impl;

import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.entity.NOA;
import com.tekanthem.finance.exception.DuplicateRecordFoundException;
import com.tekanthem.finance.repository.COARepository;
import com.tekanthem.finance.repository.NatureRepository;
import com.tekanthem.finance.service.COAService;
import com.tekanthem.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class COAServiceImpl implements COAService {

    @Autowired
    private COARepository coaRepository;

    @Autowired
    private NatureRepository natureRepository;

    @Override
    public COA saveCOA(COA entity) throws DuplicateRecordFoundException {
        COA coa = coaRepository.findCOAByDescription(entity.getDescription(), entity.getCompanyCode());
        if(coa != null){
            throw new DuplicateRecordFoundException();
        }

        int maxId = entity.getAccountCode();
        if(maxId == 0) {
            maxId = coaRepository.findMaxAccountId(entity.getType(), entity.getCompanyCode(),entity.getNature());
        }
        entity.setAccountCode(maxId);
        entity.setCreationDate(DateUtil.getSystemDate());
        entity.setStatus("A");
        return coaRepository.save(entity);
    }

    @Override
    public Page<COA> findAllByPage(Pageable paging) {
        return coaRepository.findAll(paging);
    }

    @Override
    public COA findByAccountCode(int accountCode, int companyCode) {
        return coaRepository.findCOAByAccountCode(accountCode, companyCode);
    }


}
