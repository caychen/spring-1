package org.com.cay.test;


import java.util.Arrays;

import org.com.cay.dao.IBookShopDao;
import org.com.cay.service.IBookService;
import org.com.cay.service.ICashierService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpringHibernate {

	private ApplicationContext ctx = null;
	private IBookService bookService = null;
	private IBookShopDao bookShopDao = null;
	private ICashierService cashierService = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookService = ctx.getBean(IBookService.class);
		bookShopDao = ctx.getBean(IBookShopDao.class);
		cashierService = ctx.getBean(ICashierService.class);
	}
	
	@Test
	public void testBookShopService() {
		bookService.purchase("AA", "1001");
	}
	
	@Test
	public void testCashier(){
		cashierService.checkout("AA", Arrays.asList("1001", "1002"));
	}

}
