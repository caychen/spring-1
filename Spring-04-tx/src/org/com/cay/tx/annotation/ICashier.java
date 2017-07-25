package org.com.cay.tx.annotation;

import java.util.List;

public interface ICashier {

	public void checkout(String username, List<String> isbns);
}
