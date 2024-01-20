package com.java.Investominds.repository;

import com.java.Investominds.dto.BalanceResponse;
import com.java.Investominds.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BalanceRepo extends JpaRepository<Balance,Long> {


    @Query("SELECT new com.java.Investominds.dto.BalanceResponse( c.firstName, b.available_balance) from Balance b JOIN b.user c ")
    List<BalanceResponse> findByCustomerId();

    Balance findByuser_id(Long user_id);

    @Modifying
    @Query("update Balance b set b.available_balance = :updatedbalance WHERE b.id = :user_id")
    public void updateBalanceByuser_id(@Param("updatedbalance") Double updatedbalance, @Param("user_id") Long user_id);


}

