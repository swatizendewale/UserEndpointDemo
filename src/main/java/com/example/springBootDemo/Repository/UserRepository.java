package com.example.springBootDemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springBootDemo.Model.User;

/**
 * 
 * @author Swati Zendewale
 *
 */

public interface UserRepository extends JpaRepository<User, Long>  {
	
	
	
}
