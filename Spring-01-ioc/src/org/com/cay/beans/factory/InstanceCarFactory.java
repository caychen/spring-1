package org.com.cay.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法：实例工厂的方法，即先需要创建工厂本身，再调用工厂的实例方法来返回bean实例
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
