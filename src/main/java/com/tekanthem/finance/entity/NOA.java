package com.tekanthem.finance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class NOA {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String description;
    private String code;

}
