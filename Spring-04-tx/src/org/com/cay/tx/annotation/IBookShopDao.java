package org.com.cay.tx.annotation;

public interface IBookShopDao {

	//������Ų�ѯ�鼮
	public int findBookPriceByIsbn(String isbn);
	
	//������Ÿ��¿�棬ʹ��Ŷ�Ӧ�Ŀ��-1
	public void updateBookStock(String isbn);
	
	//�����û������
	public void updateUserAccount(String username, int price);
}
