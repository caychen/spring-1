package org.com.cay.aop.helloworld;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//使用传统的方法
		ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculatorLoggingImpl();
		
		arithmeticCalculator.add(4, 2);
		arithmeticCalculator.sub(4, 2);
		arithmeticCalculator.mul(4, 2);
		arithmeticCalculator.div(4, 2);
		
		System.out.println("-----------------------------");
		ArithmeticCalculator target = new ArithmeticCalculatorImpl();
		ArithmeticCalculator proxy = new ArithmeticCalculatorLogginProxy(target).getLoggingProxy();
		System.out.println("-->" + proxy.add(4, 2));
	}

}
