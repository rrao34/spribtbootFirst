/**
 * 
 */
package com.springboot.first.controller.filter;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.bean.FilterStaticBean;

/**
 * @author e3rrao
 *
 */
@RestController
public class FilderStaticFieldsController {

	@GetMapping("/filterStaticField")
	public FilterStaticBean getFilteredValues() {
		
		return new FilterStaticBean("Name", "Address", "Id");
	}
	
	
}
