/**
 * 
 */
package com.springboot.first.controller.filter;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.springboot.first.bean.FilterDynamicBean;

/**
 * @author e3rrao
 *
 */
@RestController
public class FilderDynamicFieldsController {

	@GetMapping("/filterDynamicField")
	public MappingJacksonValue getFilteredValues() {
		
		FilterDynamicBean bean = new FilterDynamicBean("Name", "Address", "Id");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("address");
		
		FilterProvider filters = new SimpleFilterProvider().addFilter("dynamicFiltering", filter);
		
		MappingJacksonValue mapping = new MappingJacksonValue(bean);
		mapping.setFilters(filters);

		return mapping;
	}
	
	
}
