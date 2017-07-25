package org.com.cay.tx.xml.service.impl;

import java.util.List;

import org.com.cay.tx.xml.service.IBookService;
import org.com.cay.tx.xml.service.ICashierService;
import org.springframework.transaction.annotation.Transactional;

public class CashierServiceImpl implements ICashierService {

	private IBookService BookService;

	public void setBookService(IBookService bookService) {
		BookService = bookService;
	}
	
	@Transactional
	@Override
	public void checkout(String username, List<String> isbns) {
		// TODO Auto-generated method stub
		for (String isbn : isbns) {
			BookService.purchase(username, isbn);
		}
	}

}
