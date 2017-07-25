package org.com.cay.service.impl;

import java.util.List;

import org.com.cay.service.IBookService;
import org.com.cay.service.ICashierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CashierServiceImpl implements ICashierService {

	@Autowired
	private IBookService bookService;
	
	@Override
	public void checkout(String username, List<String> isbns) {
		// TODO Auto-generated method stub
		for (String isbn : isbns) {
			bookService.purchase(username, isbn);
		}
	}

}
