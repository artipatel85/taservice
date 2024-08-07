package com.tekanthem.finance.service.impl;

import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.entity.CompanyD;
import com.tekanthem.finance.exception.DuplicateRecordFoundException;
import com.tekanthem.finance.repository.CompanyRepository;
import com.tekanthem.finance.service.CompanyService;
import com.tekanthem.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyD findByDescription(String description) {
        return companyRepository.findCompanyByCompanyName(description);
    }

    @Override
    public void save(CompanyD company) throws DuplicateRecordFoundException {
        CompanyD cd = findByDescription(company.getDescription());
        if(cd != null){
            throw new DuplicateRecordFoundException();
        }

        Long maxId = company.getCompanyId();
        if(maxId == null){
            maxId = companyRepository.findMaxCompanyId();
        }
        company.setCompanyId(maxId);
        company.setCreationDate(DateUtil.getSystemDate());
        company.setStatus("A");
        companyRepository.save(company);
    }
}
