package org.com.cay.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ʵ������������ʵ�������ķ�����������Ҫ�������������ٵ��ù�����ʵ������������beanʵ��
 * @author Administrator
 *
 */
public class InstanceCarFactory {

	private Map<String, Car> cars = null;
	
	public InstanceCarFactory(){
		cars = new HashMap<>();
		cars.put("Audi", new Car("Audi", 300000));
		cars.put("Ford", new Car("Ford", 400000));
		cars.put("BMW", new Car("BMW", 500000));
	}
	
	public Car getCar(String brand){
		return cars.get(brand);
	}
}
