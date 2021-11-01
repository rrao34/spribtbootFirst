/**
 * 
 */
package com.springboot.first.bean.versioning;

/**
 * @author e3rrao
 *
 */
public class StudentBeanV1 {
	private String name;

	/**
	 * @param name
	 */
	public StudentBeanV1(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
