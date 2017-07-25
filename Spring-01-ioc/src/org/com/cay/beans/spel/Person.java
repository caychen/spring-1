package org.com.cay.beans.spel;

public class Person {

	private String name;
	private Car car;
	//引用Address的country属性
	private String country;
	//根据car的price确定info：如果car的price>=300000, 金领；否则为白领
	private String info;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", car=" + car + ", country=" + country + ", info=" + info + "]";
	}
	
}
