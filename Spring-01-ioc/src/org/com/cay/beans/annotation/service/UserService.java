package org.com.cay.beans.annotation.service;

import org.com.cay.beans.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	//Autowired���Լ��������ϣ�Ҳ���Է������Ե�setter��
	@Autowired
	@Qualifier("userRepository")//����ж�������͵�bean������ʹ�ø�ע�⣬֪ͨspring����ȥע��ƥ������ֵ�bean
	//@Qualifier("userRepository")Ҳ����д��setter�еĲ�����
	private UserRepository userRepository;
	
//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
	
	public void add(){
		System.out.println("UserService add...");
		userRepository.save();
	}
	
}
