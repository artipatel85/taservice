package com.tekanthem.finance.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Getter @Setter
public class COAModel extends RepresentationModel<COAModel> {

    private int accountCode;

    private String id;
    private int parentAccountCode;
    private int companyCode;
    private String description;
    private String type;
    private String nature;
    private String status;
    private String createdBy;
    private String creationDate;

    private List<COAModel> coaModelList;
}
