package org.com.cay.beans.relation;

import org.com.cay.beans.autowire.Address;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-relation.xml");
		
		Address address = (Address) ctx.getBean("address");
		System.out.println(address);
		
		Address address2 = (Address) ctx.getBean("address2");
		System.out.println(address2);
		
		Address address3 = (Address) ctx.getBean("address3");
		System.out.println(address3);
		
		//抽象bean，不能被实例化
//		Address address4 = (Address) ctx.getBean("address4");
//		System.out.println(address4);
		
		Address address5 = (Address) ctx.getBean("address5");
		System.out.println(address5);
	}
}
