package com.example.springBootDemo.Service;

import java.util.List;
import java.util.Optional;

import com.example.springBootDemo.Model.User;
/**
 * 
 * @author Swati Zendewale
 *
 */
public interface UserService {

	void saveUser(User user);

	List<User> findByMultipleCriteria(User user);

}
