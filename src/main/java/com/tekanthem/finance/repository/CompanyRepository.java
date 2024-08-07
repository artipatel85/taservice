package com.tekanthem.finance.repository;

import com.tekanthem.finance.entity.CompanyD;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Registered
public interface CompanyRepository extends JpaRepository<CompanyD, Long> {

    @Query(value = "SELECT c FROM CompanyD c WHERE c.description = ?1 ")
    CompanyD findCompanyByCompanyName(String description);

    @Query(value = "SELECT coalesce(MAX(companyId)+1,100000) FROM CompanyD c ")
    Long findMaxCompanyId();
}
