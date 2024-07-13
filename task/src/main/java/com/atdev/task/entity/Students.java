package com.atdev.task.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;

	int rollNo;
	String address;
	String mobileNo;

	public Students() {

	}

	public Students(String name, int rollNo, String address, String mobileNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", address=" + address + ", mobileNo="
				+ mobileNo + "]";
	}

}
