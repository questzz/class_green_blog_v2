package com.tenco.blog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tenco.blog.dto.ResponseDto;
import com.tenco.blog.model.User;
import com.tenco.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> saveUser(@RequestBody User user) {
		// 유효검사..  
		int result = userService.createUser(user);
		return new ResponseDto<Integer>(HttpStatus.OK, result);
	}
	
	
	// 전통적인 로그인 방식으로 사용 하지 않음 !! 
	// 시큐리티가 알아서 로그인 처리를 해 준다. 
	// /auth/loginProc 주소를 감지하고 있다가 요청이 들어오면 
	// 시큐리티 로그인 처리 동작을 진행한다. 
}
