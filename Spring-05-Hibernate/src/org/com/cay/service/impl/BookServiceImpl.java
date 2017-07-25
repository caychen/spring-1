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
	 * Spring Hibernate�������̣�
	 * 	1���ڷ�����ʼ֮ǰ
	 * 		(1)����ȡSession
	 * 		(2)����Session�͵�ǰ�̰߳󶨣������Ϳ�����dao��ʹ��SessionFactory��getCurrentSession()��������ȡSession��
	 * 		(3)����������
	 * 	2��������������������û�г����쳣����
	 * 		(1)���ύ����
	 * 		(2)��ʹ�͵�ǰ�̰߳󶨵�Session�����
	 * 		(3)���ر�Session
	 * 	3�������������쳣����
	 * 		(1)���ع�����
	 * 		(2)��ʹ�͵�ǰ�̰߳󶨵�Session�����
	 * 		(3)���ر�Session
	 */
	@Override
	public void purchase(String username, String isbn) {
		// TODO Auto-generated method stub
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		bookShopDao.updateBookStock(isbn);
		
		bookShopDao.updateUserAccount(username, price);
	}

}
