package org.com.cay.tx.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private IBookShopDao bookShopDao;
	
	//添加事务注解
	/**
	 * propagation:指定事务的传播行为，即当前的事务方法被另外一个事务调用时，如何使用事务
	 * 	传播行为取值有：
	 * 		REQUIRED(默认): 即使用调用方法的同一个事务
	 * 		REQUIRED_NEW: 表示方法必须启动一个新的事务，并在自己的事务中执行，如果外部已经有事务，则先挂起，等自己的事务执行完毕后，外部事务才继续
	 * 
	 * isolation:指定事务的隔离级别，最常用的取值为Isolation.READ_COMMITTED
	 * 
	 * noRollbackFor:默认情况下，Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置，通常情况下不作修改，取默认值
	 * 
	 * readOnly:指定事务是否只读，表示这个事务只读取数据而不更新数据，这样可以帮助数据库引擎优化事务。
	 * 	如果真的是只读事务的话，应设置readOnly=true
	 * 
	 * timeout:指定强制回滚之前事务可以占用的时间，单位为s，如果事务占用时间大于timeout的值，则事务就会被强制回滚
	 */
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED
			//noRollbackFor={UserAccountException.class},
			,readOnly=false,timeout=1
			)
	@Override
	public void purchase(String username, String isbn) {
		// TODO Auto-generated method stub
		//1、获取书的单价
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2、更新书的库存
		bookShopDao.updateBookStock(isbn);
		
		//3、更新账户余额
		bookShopDao.updateUserAccount(username, price);
	}

}
