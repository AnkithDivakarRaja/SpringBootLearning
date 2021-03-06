package com.springboot.learning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springboot.learning.model.User;
import com.springboot.learning.service.UserService;
import com.springboot.learning.util.CustomError;

@RestController
@RequestMapping("/REST")
public class RestControllerApi {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/GetAllUsers", method=RequestMethod.GET)
	ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/UserDetails/{id}", method=RequestMethod.GET)
	ResponseEntity<?> getUserDetails(@PathVariable("id") long id){
		User user = userService.getUserDetails(id);
		if(user == null) {
			return new ResponseEntity<>(new CustomError("User with id: " + id + " does not found. "),HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value="/AddUser/", method=RequestMethod.POST)
	ResponseEntity<?> createNewUser(@RequestBody User user, UriComponentsBuilder uriBuilder ){
		if(userService.isUserPresent(user)) {
			return new ResponseEntity<>(new CustomError("User with name: " + user.getFirstName() + " already exist. "),HttpStatus.CONFLICT);
		}
		userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriBuilder.path("/REST/UserDetails/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}
	
	 @RequestMapping(value = "/UserDetails/{id}", method = RequestMethod.PUT)
	 public ResponseEntity<?> updateUser(@PathVariable("id") long id, @RequestBody User user) {
	        
		User currentUser = userService.getUserDetails(id);

		if (currentUser == null) {
			return new ResponseEntity<>(new CustomError("Unable to upate. User with id: " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentUser.setFirstName(user.getFirstName());
		currentUser.setLastName(user.getLastName());
		currentUser.setAddress(user.getAddress());
		currentUser.setAge(user.getAge());
		currentUser.setSalary(user.getSalary());

		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	 }
	 
	 @RequestMapping(value = "/DeleteUser/{id}", method = RequestMethod.DELETE)
	 public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
		
		 User currentUser = userService.getUserDetails(id);

			if (currentUser == null) {
				return new ResponseEntity<>(new CustomError("Unable to delete. User with id: " + id + " not found."),
						HttpStatus.NOT_FOUND);
			}
		userService.deleteUser(currentUser);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	 }
	        
	 
}
