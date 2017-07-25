package org.com.cay.service.impl;

import org.com.cay.dao.IBookShopDao;
import org.com.cay.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookShopDao bookShopDao;
	
	/**
	 * Spring Hibernate事务流程：
	 * 	1、在方法开始之前
	 * 		(1)、获取Session
	 * 		(2)、把Session和当前线程绑定，这样就可以在dao中使用SessionFactory的getCurrentSession()方法来获取Session了
	 * 		(3)、开启事务
	 * 	2、若方法正常结束，即没有出现异常，则
	 * 		(1)、提交事务
	 * 		(2)、使和当前线程绑定的Session解除绑定
	 * 		(3)、关闭Session
	 * 	3、若方法出现异常，则
	 * 		(1)、回滚事务
	 * 		(2)、使和当前线程绑定的Session解除绑定
	 * 		(3)、关闭Session
	 */
	@Override
	public void purchase(String username, String isbn) {
		// TODO Auto-generated method stub
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		bookShopDao.updateBookStock(isbn);
		
		bookShopDao.updateUserAccount(username, price);
	}

}
