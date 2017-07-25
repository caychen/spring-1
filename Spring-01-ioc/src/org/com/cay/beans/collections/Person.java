package org.com.cay.beans.collections;

import java.util.List;

public class Person {

	private String name;
	private List<Car> car;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Car> getCar() {
		return car;
	}
	public void setCar(List<Car> car) {
		this.car = car;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + "]";
	}
	
}
