package com.example.redisDemo.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.redisDemo.bean.User;
@RestController
@RequestMapping(value="/redis")
public class RedisController {
	@Autowired
	private RedisTemplate redisTemplate;
	
	@RequestMapping(value="/getUser",method=RequestMethod.GET)
	public User getUser() throws UnsupportedEncodingException {
		User user =  (User) redisTemplate.opsForList().leftPop("redis_user_mlf_key");
		return user;
	}
	
	@RequestMapping(value="/saveUser",method=RequestMethod.GET)
	public void testRedis() throws UnsupportedEncodingException {
		//
		User user = new User(1, "1", "mlf", "male", "henu", "zhegnzhou", "CN");
		redisTemplate.opsForList().leftPush("redis_user_mlf_key", user);
	}
	
}
	

