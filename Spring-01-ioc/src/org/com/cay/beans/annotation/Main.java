package org.com.cay.beans.annotation;

import org.com.cay.beans.annotation.controller.UserController;
import org.com.cay.beans.annotation.repository.UserRepositoryImpl;
import org.com.cay.beans.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");
		TestObject to = (TestObject) ctx.getBean("testObject");
//		System.out.println(to);
//		
		UserController userController = (UserController) ctx.getBean("userController");
		userController.execute();
//		
//		UserRepositoryImpl userRepository = (UserRepositoryImpl) ctx.getBean("userRepository");
//		userRepository.save();
//		
//		UserService userService = (UserService) ctx.getBean("userService");
//		userService.add();
		
	}

}
