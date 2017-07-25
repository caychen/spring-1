package org.com.cay.aop.impl.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator) ctx.getBean(ArithmeticCalculator.class);
		System.out.println(arithmeticCalculator);
		int result = arithmeticCalculator.add(2, 3);
		System.out.println(result);
		
		result = arithmeticCalculator.mul(2, 3);
		System.out.println(result);
		
//		result = arithmeticCalculator.div(2, 0);
//		System.out.println(result);
	}

}
