package com.tekanthem.finance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
@Table(name = "user_d")
public class UserD {
    @Id
    @Column(name = "user_id", nullable = false)
    private String userId;

    private String userName;
    private String password;
    private String role;
    private String status;
}
