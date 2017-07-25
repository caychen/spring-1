package org.com.cay.beans.collections;

import java.util.List;
import java.util.Map;

public class NewPerson {

	private String name;
	private Map<String, Car> car;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, Car> getCar() {
		return car;
	}
	public void setCar(Map<String, Car> car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "NewPerson [name=" + name + ", car=" + car + "]";
	}
	
}
