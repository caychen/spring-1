package org.com.cay.tx.xml;


import java.util.Arrays;

import org.com.cay.tx.xml.service.IBookService;
import org.com.cay.tx.xml.service.ICashierService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTransactionTest {

	private ApplicationContext ctx = null;
	private IBookShopDao bookShopDao = null;
	private IBookService bookService = null;
	private ICashierService cashier = null;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext-tx-xml.xml");
		bookShopDao = ctx.getBean(IBookShopDao.class);
		bookService = ctx.getBean(IBookService.class);
		cashier = ctx.getBean(ICashierService.class);
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
