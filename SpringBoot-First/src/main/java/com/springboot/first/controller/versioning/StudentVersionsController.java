/**
 * 
 */
package com.springboot.first.controller.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.bean.versioning.Name;
import com.springboot.first.bean.versioning.StudentBeanV1;
import com.springboot.first.bean.versioning.StudentBeanV2;

/**
 * @author e3rrao
 *
 */
@RestController
public class StudentVersionsController {
	
	@GetMapping(value="/student/paramBased", params="version=1")
	public StudentBeanV1 getStudentParamBasedVersionV1() {
		return new StudentBeanV1("Fedele Cosentino");
	}
	
	@GetMapping(value="/student/paramBased", params="version=2")
	public StudentBeanV2 getStudentParamBasedVersionV2() {
		return new StudentBeanV2(new Name("Fedele", "Cosentino"));
	}
	
	@GetMapping(value="/student/headerBased", headers="HEADER-API-VERSION=1")
	public StudentBeanV1 getStudentHeaderBasedVersionV1() {
		return new StudentBeanV1("Fedele Cosentino");
	}
	
	@GetMapping(value="/student/headerBased", headers="HEADER-API-VERSION=2")
	public StudentBeanV2 getStudentHeaderBasedVersionV2() {
		return new StudentBeanV2(new Name("Fedele", "Cosentino"));
	}
	
	@GetMapping(value="/student/producerBased", produces="application/vnd.company.app-v1+json")
	public StudentBeanV1 getStudentProducerBasedVersionV1() {
		return new StudentBeanV1("Fedele Cosentino");
	}
	
	@GetMapping(value="/student/producerBased", produces="application/versionV2+json")
	public StudentBeanV2 getStudentProducerBasedVersionV2() {
		return new StudentBeanV2(new Name("Fedele", "Cosentino"));
	}

}
