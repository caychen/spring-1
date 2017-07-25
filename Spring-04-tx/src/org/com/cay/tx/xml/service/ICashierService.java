package org.com.cay.tx.xml.service;

import java.util.List;

public interface ICashierService {

	public void checkout(String username, List<String> isbns);
}
