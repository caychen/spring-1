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
	
	//�������ע��
	/**
	 * propagation:ָ������Ĵ�����Ϊ������ǰ�����񷽷�������һ���������ʱ�����ʹ������
	 * 	������Ϊȡֵ�У�
	 * 		REQUIRED(Ĭ��): ��ʹ�õ��÷�����ͬһ������
	 * 		REQUIRED_NEW: ��ʾ������������һ���µ����񣬲����Լ���������ִ�У�����ⲿ�Ѿ����������ȹ��𣬵��Լ�������ִ����Ϻ��ⲿ����ż���
	 * 
	 * isolation:ָ������ĸ��뼶����õ�ȡֵΪIsolation.READ_COMMITTED
	 * 
	 * noRollbackFor:Ĭ������£�Spring������ʽ��������е�����ʱ�쳣���лع���Ҳ����ͨ����Ӧ�����Խ������ã�ͨ������²����޸ģ�ȡĬ��ֵ
	 * 
	 * readOnly:ָ�������Ƿ�ֻ������ʾ�������ֻ��ȡ���ݶ����������ݣ��������԰������ݿ������Ż�����
	 * 	��������ֻ������Ļ���Ӧ����readOnly=true
	 * 
	 * timeout:ָ��ǿ�ƻع�֮ǰ�������ռ�õ�ʱ�䣬��λΪs���������ռ��ʱ�����timeout��ֵ��������ͻᱻǿ�ƻع�
	 */
	@Transactional(propagation=Propagation.REQUIRED,
			isolation=Isolation.READ_COMMITTED
			//noRollbackFor={UserAccountException.class},
			,readOnly=false,timeout=1
			)
	@Override
	public void purchase(String username, String isbn) {
		// TODO Auto-generated method stub
		//1����ȡ��ĵ���
		int price = bookShopDao.findBookPriceByIsbn(isbn);
		
		//2��������Ŀ��
		bookShopDao.updateBookStock(isbn);
		
		//3�������˻����
		bookShopDao.updateUserAccount(username, price);
	}

}
