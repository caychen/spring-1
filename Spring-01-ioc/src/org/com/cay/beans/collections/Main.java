package org.com.cay.beans.collections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		Person person2 = (Person) ctx.getBean("person2");
		System.out.println(person2);
		
		NewPerson newPerson = (NewPerson) ctx.getBean("newPerson");
		System.out.println(newPerson);
		
		Person person3 = (Person) ctx.getBean("person3");
		System.out.println(person3);
		
		Person person4 = (Person) ctx.getBean("person4");
		System.out.println(person4);
	}
	
}
