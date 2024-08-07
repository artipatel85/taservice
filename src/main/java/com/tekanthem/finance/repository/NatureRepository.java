package com.tekanthem.finance.repository;

import com.tekanthem.finance.entity.COA;
import com.tekanthem.finance.entity.NOA;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NatureRepository extends JpaRepository<NOA, Integer> {

}
