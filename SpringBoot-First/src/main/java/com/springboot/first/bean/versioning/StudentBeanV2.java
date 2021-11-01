/**
 * 
 */
package com.springboot.first.bean.versioning;

/**
 * @author e3rrao
 *
 */
public class StudentBeanV2 {
	private Name name;

	/**
	 * @param name
	 */
	public StudentBeanV2(Name name) {
		super();
		this.name = name;
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	
	
}
