package org.sagar.services;

import java.util.List;
import java.util.Optional;

import org.sagar.dto.AddUserRequest;
import org.sagar.dto.AddUserResponse;
import org.sagar.dto.LoginUserRequest;
import org.sagar.dto.UserData;
import org.sagar.dto.UserResponse;
import org.sagar.entity.Users;
import org.sagar.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManagementService {
	
	@Autowired
	UserRepository userRepo;

	public AddUserResponse addUser(AddUserRequest userRequest)
	{
		AddUserResponse response = new AddUserResponse();
		
		Users u = new Users();
		
		if(userRequest.getUsername().isEmpty())
		{
			response.setStatus("Unsuccess");
			response.setMessage("user not added successfully");
		}
		else
		{
			u.setUsername(userRequest.getUsername());
			u.setPassword(userRequest.getPassword());
			u.setEmail(userRequest.getEmail());
			u.setAge(userRequest.getAge());
			
			u =userRepo.save(u);
			
			response.setStatus("Success");
			response.setMessage("user added successfully");
			response.setUserId(u.getUser_id());
			
			response.setUsername(userRequest.getUsername());
			response.setPassword(userRequest.getPassword());
			response.setEmail(userRequest.getEmail());
			response.setAge(userRequest.getAge());
		}
		
		return response;
	}
	
	public AddUserResponse getSingleUser(Long user_id)
	{
		AddUserResponse user = new AddUserResponse();
		
		Optional<Users> receivedData = userRepo.findById(user_id);
		
		if(receivedData.isEmpty())
		{
			user.setStatus("Unsuccess");
			user.setMessage("User not found");
			user.setUserId(user_id);
		}
		else
		{
			Users u = receivedData.get();
			user.setStatus("Success");
			user.setMessage("User Data found");
			user.setUserId(user_id);
			
			user.setUsername(u.getUsername());
			user.setPassword(u.getPassword());
			user.setEmail(u.getEmail());
			user.setAge(u.getAge());
		}
		
		return user;
	}
	
	public UserResponse deleteSingleUser(Long user_id)
	{
		UserResponse user = new UserResponse();
		
		Optional<Users> data = userRepo.findById(user_id);
		
		if(data.isEmpty())
		{
			user.setStatus("Unsuccess");
			user.setMessage("User not found");
			user.setUserId(user_id);
		}
		else
		{
			Users u = data.get();
			userRepo.delete(u);
			user.setUserId(user_id);
			user.setStatus("Success");
			user.setMessage("User deleted successfully");
		}
		
		return user;
	}
	
	public List<Users> getAllUsers()
	{
		return userRepo.findAll();
	}
}
