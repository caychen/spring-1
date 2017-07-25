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
	
	//���Ƽ�ʹ��HibernateTemplate��HibernateDaoSupport
	//��Ϊ�����ᵼ��dao��spring��api������ϣ�����ֲ�Ա��
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
		//��֤��Ŀ���Ƿ��㹻
		String hql2 = "select b.stock from Book b where b.isbn = ?";
		int stock = (int) getSession().createQuery(hql2).setParameter(0, isbn).getSingleResult();
		if(stock == 0){
			throw new BookShopException("��治�㣡");
		}
		
		String hql = "update Book b set b.stock = b.stock - 1 where b.isbn = ?";
		getSession().createQuery(hql).setParameter(0, isbn).executeUpdate();
	}

	@Override
	public void updateUserAccount(String username, int price) {
		// TODO Auto-generated method stub
		//��֤����Ƿ��㹻
		String hql = "select a.balance from Account a where a.username = ?";
		int balance = (int) getSession().createQuery(hql).setParameter(0, username).getSingleResult();
		if(balance < price){
			throw new UserAccountException("���㣡");
		}
		
		String hql2 = "update Account a set a.balance = a.balance - ? where a.username = ?";
		getSession().createQuery(hql2).setParameter(0, price).setParameter(1, username).executeUpdate();
	}

}
