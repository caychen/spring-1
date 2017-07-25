package org.com.cay.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookShopDaoImpl implements IBookShopDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int findBookPriceByIsbn(String isbn) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject("select price from book where isbn = ?", Integer.class, isbn);
	}

	@Override
	public void updateBookStock(String isbn) {
		// TODO Auto-generated method stub
		//检查书的库存是否足够，若不够，则抛出异常
		int stock = jdbcTemplate.queryForObject("select stock from book_stock where isbn=?", Integer.class, isbn);
		if(stock == 0){
			throw new BookShopException("库存不足！");
		}
		jdbcTemplate.update("update book_stock set stock = stock - 1 where isbn = ?", isbn);
	}

	@Override
	public void updateUserAccount(String username, int price) {
		// TODO Auto-generated method stub
		int balance = jdbcTemplate.queryForObject("select balance from account where username=?", Integer.class, username);
		if(balance < price){
			throw new UserAccountException("余额不足！");
		}
		jdbcTemplate.update("update account set balance = balance - ? where username = ?", price, username);
	}

}
