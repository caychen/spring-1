package org.com.cay.tx.annotation;

public interface IBookShopDao {

	//根据书号查询书籍
	public int findBookPriceByIsbn(String isbn);
	
	//根据书号更新库存，使书号对应的库存-1
	public void updateBookStock(String isbn);
	
	//更新用户的余额
	public void updateUserAccount(String username, int price);
}
