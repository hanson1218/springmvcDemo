package com.snow.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.snow.www.dao.UserMapper;
import com.snow.www.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	public String getNameById(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectByPrimaryKey(id).toString();
	}

}
