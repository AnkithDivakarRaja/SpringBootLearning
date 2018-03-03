package com.springboot.learning.model;

public class User {

	private long id;
	private String firstName;
	private String lastName;
	private String address;
	private int age;
	private double salary;
	
	public User(){
        id=0;
    }
	
	public User(long id, String fName, String lName, int age, String address, double salary){
        this.id = id;
        this.firstName = fName;
        this.lastName = lName;
        this.age = age;
        this.address = address;
        this.salary = salary;
    }
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
