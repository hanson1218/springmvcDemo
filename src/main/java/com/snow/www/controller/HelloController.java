package com.snow.www.controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class HelloController {

	@RequestMapping("/requestParam")
	public String hello(@RequestParam(value="name") String test){
		return test;
	}
	
	@RequestMapping("/requestParam")
	public String testEhcahe(@RequestParam(value="name") String test){
		return test;
	}
	
	
}
