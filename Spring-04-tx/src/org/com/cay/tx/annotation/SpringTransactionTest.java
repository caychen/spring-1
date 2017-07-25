package org.com.cay.tx.annotation;


import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private IBookShopDao bookShopDao = null;
	private IBookService bookService = null;
	private ICashier cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		bookShopDao = ctx.getBean(IBookShopDao.class);
		bookService = ctx.getBean(IBookService.class);
		cashier = ctx.getBean(ICashier.class);
	}
	
	@Test
	public void testFindBookPriceByIsbn() {
		System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
	}

	@Test
	public void testUpdateBookStock(){
		bookShopDao.updateBookStock("1001");
	}
	
	@Test
	public void testUpdateUserAccount(){
		bookShopDao.updateUserAccount("AA", 300);
	}
	
	@Test
	public void testBookShopService(){
		bookService.purchase("AA", "1001");
	}
	
	@Test
	public void testTransactionPropagation(){
		cashier.checkout("AA", Arrays.asList("1001","1002"));
	}
}
