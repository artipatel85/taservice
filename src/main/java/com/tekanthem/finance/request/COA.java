package com.tekanthem.finance.request;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class COA {
    private String id;

    private int accountCode;
    private int parentAccountCode;
    private int companyCode;
    private String description;
    private String accountType;
    private String natureOfAccount;
    private String status;
    private String createdBy;
    private String creationDate;
    private String amendedBy;
    private String amendedDate;
}
