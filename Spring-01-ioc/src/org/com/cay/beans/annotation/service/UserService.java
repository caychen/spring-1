package org.com.cay.beans.annotation.service;

import org.com.cay.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	//Autowired可以加在属性上，也可以放在属性的setter上
	@Autowired
	@Qualifier("userRepository")//如果有多个该类型的bean，可以使用该注解，通知spring容器去注入匹配该名字的bean
	//@Qualifier("userRepository")也可以写在setter中的参数上
	private UserRepository userRepository;
	
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
	public void add(){
		System.out.println("UserService add...");
		userRepository.save();
	}
	
}
