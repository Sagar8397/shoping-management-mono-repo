package org.sagar.controller;

import java.util.List;

import org.sagar.dto.AddUserRequest;
import org.sagar.dto.AddUserResponse;
import org.sagar.dto.LoginUserRequest;
import org.sagar.dto.UserResponse;
import org.sagar.entity.Users;
import org.sagar.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class UserManagementController {

	@Autowired
	UserManagementService userService;
	
	@PostMapping(path = "/api/v1/user/add/update" , 
			consumes = {"application/json" , "application/xml"} , 
			produces = {"application/json" , "application/xml"})
	public AddUserResponse userService(@RequestBody AddUserRequest userRequest)
	{
		return userService.addUser(userRequest);
	}
	
	@GetMapping(path = "/api/v1/user/search/{user_id}") 
	public AddUserResponse getSingleUser(@PathVariable Long user_id)
	{
		return userService.getSingleUser(user_id);
	}
	
	@DeleteMapping(path = "/api/v1/user/delete/{user_id}")
	public UserResponse deleteSingleUser(@PathVariable Long user_id)
	{
		return userService.deleteSingleUser(user_id);
	}
	
	@GetMapping(path = "/auth/user")
	public List<Users> getAllUser()
	{
		return userService.getAllUsers();
	}
}
