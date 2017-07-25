package org.com.cay.aop.impl;

import org.springframework.stereotype.Component;

@Component
public class ArithmeticCalculatorImpl implements ArithmeticCalculator {

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		int result = a + b;
		return result;
	}

	@Override
	public int sub(int a, int b) {
		// TODO Auto-generated method stub
		int result = a - b;
		return result;
	}

	@Override
	public int mul(int a, int b) {
		// TODO Auto-generated method stub
		int result = a * b;
		return result;
	}

	@Override
	public int div(int a, int b) {
		// TODO Auto-generated method stub
		int result = a / b;
		return result;
	}

}
