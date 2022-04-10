package com.fwork.model;

public class Address {
	String area;
	String city;
	String State;

	public Address() {
	}
	
	public Address(String area, String city, String state) {
		this.area = area;
		this.city = city;
		State = state;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		State = state;
	}

	public String getArea() {
		return area;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return State;
	}

	@Override
	public String toString() {
		return "Address{" +
				"area='" + area + '\'' +
				", city='" + city + '\'' +
				", State='" + State + '\'' +
				'}';
	}
}
