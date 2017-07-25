package org.com.cay.beans.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * ��̬����������ֱ�ӵ���ĳһ����ľ�̬�����Ϳ��Է���bean��ʵ��
 * @author Administrator
 *
 */
public class StaticCarFatory {

	private static Map<String, Car> cars = new HashMap<String, Car>();
	
	static{
		cars.put("Audi", new Car("Audi", 300000));
		cars.put("Ford", new Car("Ford", 400000));
		cars.put("BMW", new Car("BMW", 500000));
	}
	
	public static Car getCar(String name){
		return cars.get(name);
	}
}
