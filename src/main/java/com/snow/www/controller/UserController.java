package com.snow.www.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.snow.www.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	private static Logger Logger = LoggerFactory.getLogger(UserController.class);

	@RequestMapping("/{id}")
	public String getNameById(@PathVariable int id){
		try {
			int a = 1/0;
		} catch (Exception e) {
			Logger.error("test");
		}
		
		return userService.getNameById(id);
	}
}
