package com.springboot.first.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
//@Table(name="StudentBean")
public class StudentBean {

	@Min(value=1,message="Id should be greater than 0")
	@Id
	@GeneratedValue
	private int id;
	@Size(min=2, message="Name should be 2 characters in length")
	private String name;
	
	private String Address;

	/**
	 * @param id
	 * @param name
	 * @param address
	 */
	public StudentBean(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		Address = address;
	}

	/**
	 * 
	 */
	public StudentBean() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

}
