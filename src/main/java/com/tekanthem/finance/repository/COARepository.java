package com.tekanthem.finance.repository;

import com.tekanthem.finance.entity.COA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springfox.documentation.annotations.ApiIgnore;

@Repository
@ApiIgnore
public interface COARepository extends JpaRepository<COA, String> {

    @Query(value = "SELECT coalesce(MAX(accountCode)+1,0) FROM COA n WHERE n.type = ?1 and n.companyCode=?2 and n.nature=?3")
    Integer findMaxAccountId(String type, int companyCode, String nature);

    @Query(value = "SELECT c FROM COA c WHERE c.description = ?1 AND c.companyCode=?2")
    COA findCOAByDescription(String description, int companyCode);

    @Query(value = "SELECT c FROM COA c WHERE c.accountCode = ?1 AND c.companyCode=?2")
    COA findCOAByAccountCode(int accountCode, int companyCode);
}
