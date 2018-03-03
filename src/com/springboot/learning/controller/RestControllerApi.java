package com.springboot.learning.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.learning.model.User;
import com.springboot.learning.service.UserService;

@RestController
@RequestMapping("/REST")
public class RestControllerApi {

	UserService userService;
	
	@RequestMapping(value="/GetAllUsers", method=RequestMethod.GET)
	ResponseEntity<List<User>> getAllUsers(){
		List<User> users = userService.getAllUsers();
		if(users.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
}
