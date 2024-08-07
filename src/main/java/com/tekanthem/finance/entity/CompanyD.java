package com.tekanthem.finance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "company_d")
public class CompanyD extends AbstractEntity implements Serializable {
    @Id
    @Column(name = "company_id", nullable = false)
    private Long companyId;

    private String description;
    private String address1;
    private String address2;
    private String panNo;
    private String tanNo;
    private String cityName;
    private String stateCode;
    private String countryCode;
    private String email;
    private String status;
    private String createdBy;
    private String creationDate;
    private String amendedBy;
    private String amendedDate;
}
