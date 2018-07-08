package com.snow.www.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

	@RequestMapping("test")
	public String hello(){
		return "hello1";
	}
}
