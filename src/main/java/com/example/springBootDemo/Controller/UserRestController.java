package com.example.springBootDemo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springBootDemo.DTO.UserDTO;
import com.example.springBootDemo.Model.User;
import com.example.springBootDemo.Repository.UserRepository;
import com.example.springBootDemo.Service.UserService;

/**
 * 
 * @author Swati Zendewale
 *
 */

@RestController
@RequestMapping(path="/userApi")
public class UserRestController {


	@Autowired
	private UserService userServiceImpl;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String display() {
		return "Swati";

	}

	@PostMapping(value="saveUser")
	public void saveUser(UserDTO userDto) {
        User user= new User();
        BeanUtils.copyProperties(userDto, user);
		userServiceImpl.saveUser(user);


	}

	@GetMapping(value="/users/{userId}")
	public Optional<User> getUsers(@PathVariable("userId")Long userId){
		return userRepository.findById(userId);
	}
	
	@GetMapping(value="/user")
	public List<User> getUserDynamically(User user){
		return userServiceImpl.findByMultipleCriteria(user);
	}
}



