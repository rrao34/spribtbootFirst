/**
 * 
 */
package com.springboot.first.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author e3rrao
 *
 */
@JsonIgnoreProperties(value= {"id"})
public class FilterStaticBean {

	private String name;
	private String address;
	//@JsonIgnore	
	private String id;
	/**
	 * @param name
	 * @param address
	 * @param id
	 */
	public FilterStaticBean(String name, String address, String id) {
		super();
		this.name = name;
		this.address = address;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
