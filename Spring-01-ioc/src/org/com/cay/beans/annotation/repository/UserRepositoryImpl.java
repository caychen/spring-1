package org.com.cay.beans.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository(value="userRepository")
public class UserRepositoryImpl implements UserRepository {

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("UserRepository Save...");
	}

}
