package org.com.cay.dao.impl;

import org.com.cay.dao.IBookShopDao;
import org.com.cay.exception.BookShopException;
import org.com.cay.exception.UserAccountException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements IBookShopDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	//不推荐使用HibernateTemplate和HibernateDaoSupport
	//因为这样会导致dao和spring的api进行耦合，可移植性变差
	//private HibernateTemplate hibernateTemplate;
	
	private Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		// TODO Auto-generated method stub
		String hql = "select b.price from Book b where b.isbn = ?";
		return (int) getSession().createQuery(hql).setParameter(0, isbn).getSingleResult();
	}

	@Override
	public void updateBookStock(String isbn) {
		// TODO Auto-generated method stub
		//验证书的库存是否足够
		String hql2 = "select b.stock from Book b where b.isbn = ?";
		int stock = (int) getSession().createQuery(hql2).setParameter(0, isbn).getSingleResult();
		if(stock == 0){
			throw new BookShopException("库存不足！");
		}
		
		String hql = "update Book b set b.stock = b.stock - 1 where b.isbn = ?";
		getSession().createQuery(hql).setParameter(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
		// TODO Auto-generated method stub
		//验证余额是否足够
		String hql = "select a.balance from Account a where a.username = ?";
		int balance = (int) getSession().createQuery(hql).setParameter(0, username).getSingleResult();
		if(balance < price){
			throw new UserAccountException("余额不足！");
		}
		
		String hql2 = "update Account a set a.balance = a.balance - ? where a.username = ?";
		getSession().createQuery(hql2).setParameter(0, price).setParameter(1, username).executeUpdate();
	}

}
