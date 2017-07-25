package org.com.cay.beans.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-factorybean.xml");
		
		Car car = (Car) ctx.getBean("car");
		System.out.println(car);
	}

}
