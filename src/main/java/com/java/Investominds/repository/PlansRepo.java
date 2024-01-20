package com.java.Investominds.repository;

import com.java.Investominds.model.Plans;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface PlansRepo extends JpaRepository<Plans,Long> {

    @Query(value ="SELECT * FROM investo.investment_plans where id in (select plans_id from investo.users_plans where user_id = :user_id)", nativeQuery = true)
    List<Plans> findAllUserPlans( @Param("user_id") Long user_id);

}









































/*
    @Query("update Student s SET s.studentName = :studentName WHERE s.id = :id")
    public void updateStudentUsingQueryAnnotation(@Param("studentName") String studentName, @Param("id") int id);
*/

/* SELECT * FROM investo.investment_plans where id in (select plans_id from investo.users_plans where user_id=21);*/


   /* @Query("select tapa fom PriceAlertsTapas pat join pat.tapa tapa where pat.priceAlert = ?1")
    List<Tapa> tapasByUserPriceAlert (PriceAlert pa);*/
