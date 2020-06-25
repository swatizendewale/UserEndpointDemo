package com.example.springBootDemo.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springBootDemo.Model.User;
import com.example.springBootDemo.Repository.UserDaoImpl;
import com.example.springBootDemo.Repository.UserRepository;
import com.example.springBootDemo.Service.UserService;
/**
 * 
 * @author Swati Zendewale
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	UserDaoImpl userDaoImpl;

	@Override
	public void saveUser(User user) {

		userRepository.save(user);
	}

	@Override
	public List<User> findByMultipleCriteria(User user) {
		return userDaoImpl.fetchUsers(user);
	}


}
