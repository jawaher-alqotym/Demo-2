package com.example.demo2.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;


@RestController
public class UserController {
   
	
    @Autowired 
    private UserServices userServices;
	   
	@GetMapping(path = "api/v1/user_name/{name}")
	public String getHellowUserNamw(@PathVariable String name) {
		return String.format("hi %s", name);
	}
	
	
	@GetMapping(path = "api/v1/users")
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.status(HttpStatus.OK).body(userServices.findAll());

	}
	
	@GetMapping(path = "api/v1/user_info/{user_id}")
	public ResponseEntity<User> getUser(@PathVariable String user_id) {
		User foundUser =  userServices.findOne(Integer.parseInt(user_id));
		
		if(foundUser == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(foundUser);
	}
	
	@PostMapping(path = "api/v1/user")
	public ResponseEntity<User> postUser(@Valid @RequestBody User user) {
		if(user.getFname() == null || user.getLname()== null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "HTTP Status Bad Request");
		}
		User savedUser = userServices.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	
	@DeleteMapping(path = "api/v1/delete_user/{user_id}")
	public ResponseEntity<User> deleteUser(@PathVariable String user_id) {
		User deleted_user = userServices.deleteById(Integer.parseInt(user_id));
		
		if(deleted_user == null) {
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "HTTP Status Bad Request, user not found");
		}
		return ResponseEntity.status(HttpStatus.OK).body(deleted_user);
		
	}
	
	
	
	
	

}
