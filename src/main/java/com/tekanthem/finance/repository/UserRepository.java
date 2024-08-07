package com.tekanthem.finance.repository;


import com.tekanthem.finance.entity.UserD;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<UserD, String> {

    @Query(value = "SELECT u FROM UserD u WHERE u.userName = ?1 ")
    UserD findByUserName(String userName);
}
