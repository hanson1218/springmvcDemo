package com.snow.www.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snow.www.dao.UserMapper;
import com.snow.www.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	private static Logger Logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserMapper userMapper;
	
	public String getNameById(int id) {
		try {
			int a = 1/1;
		} catch (Exception e) {
			Logger.error("test service");
		}
		return userMapper.selectByPrimaryKey(id).toString();
	}

}
