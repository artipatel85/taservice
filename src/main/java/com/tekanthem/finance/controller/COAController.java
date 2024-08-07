package com.tekanthem.finance.controller;

import com.tekanthem.finance.assembler.COAAssember;
import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.exception.DuplicateRecordFoundException;
import com.tekanthem.finance.model.COAModel;
import com.tekanthem.finance.service.COAService;
import com.tekanthem.model.TAResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/v1/coa")
public class COAController {

    @Autowired
    private COAService coaService;

    @Autowired
    private PagedResourcesAssembler<COA> pagedResourcesAssembler;

    @Autowired
    private COAAssember coaAssember;

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody COA coa){
        coa.setId(UUID.randomUUID().toString());
        try {
            coaService.saveCOA(coa);
        } catch (DuplicateRecordFoundException e) {
            return new ResponseEntity(new TAResponse(null, "Duplicate Account Record.", null, false),
                    HttpStatus.NOT_ACCEPTABLE);
        }
        String infoMsg = "COA Record created Successfully!";
        return new ResponseEntity(new TAResponse(coa, null, infoMsg, true), HttpStatus.OK);
    }

    @GetMapping("/getByPage")
    public ResponseEntity getCOAByPage(Pageable pageable){
        Page<COA> pageData = coaService.findAllByPage(pageable);
        PagedModel<COAModel> coaModel = pagedResourcesAssembler.toModel(pageData, coaAssember);
        String infoMsg = "COA Records retrieved Successfully!";
        // Retrieve the items
        return new ResponseEntity(new TAResponse(coaModel, null, infoMsg,true), HttpStatus.OK);
    }

    @GetMapping("/get")
    public COA get(@RequestParam int accountCode,
                   @RequestParam int companyCode){
        return coaService.findByAccountCode(accountCode, companyCode);
    }

}
