package com.java.Investominds.repository;

import com.java.Investominds.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	User findByLoginid(String loginid);


}
