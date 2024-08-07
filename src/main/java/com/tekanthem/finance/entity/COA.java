package com.tekanthem.finance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

@Entity
@Getter @Setter
public class COA implements Serializable {
    @Id
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
    private String amendedBy;
    private String amendedDate;

}
