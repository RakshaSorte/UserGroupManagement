package com.capgemini.manageuser.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageuser.exception.ResourceNotFoundException;
import com.capgemini.manageuser.model.GroupUser;
import com.capgemini.manageuser.model.User;
import com.capgemini.manageuser.repository.GroupUserRepository;
import com.capgemini.manageuser.repository.UserRepository;


/**
 * The Class RegisterUserController.
 */

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="http://localhost:3000")
public class UserController {


		@Autowired
		private UserRepository userRepository;
		@Autowired
		private GroupUserRepository groupUserRepository;
		//http://localhost:8088/api/users/
		@GetMapping("/")
		public List<User> getAllUser()
		{
			return userRepository.findAll();
		}
		//http://localhost:8088/api/users/
		@PostMapping("/") 
		public void createUser(@RequestBody User user) { 
			userRepository.save(user); 
			GroupUser groupUser=new GroupUser(user);
			 groupUserRepository.save(groupUser);
		
		
			}
		 //get user by id
		@GetMapping("/{id}")
		public ResponseEntity<User> getUserById(@PathVariable int id) throws ResourceNotFoundException {
			User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
					
		return  ResponseEntity.ok(user);
		}
		
		//update user rest api
		@PutMapping("/{id}")
		public ResponseEntity<User> updateUser(@PathVariable int id,@RequestBody User userDetails) throws ResourceNotFoundException
		{
			User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
		user.setUsername(userDetails.getUsername());
	user.setPassword(userDetails.getPassword());
	user.setCountry(userDetails.getCountry());
	user.setPincode(userDetails.getPincode());
	user.setRole(userDetails.getRole());
	User updatedUser =userRepository.save(user);
		return ResponseEntity.ok(updatedUser);
		}
		//delete user rest api
		@DeleteMapping("/{id}")
		public ResponseEntity< Map<String,Boolean>> deleteUser(@PathVariable int id) throws ResourceNotFoundException
		{
			User user=userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user not found"));
			
			userRepository.delete(user);
			Map<String,Boolean> response=new HashMap<>();
			response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		}
		
	}

