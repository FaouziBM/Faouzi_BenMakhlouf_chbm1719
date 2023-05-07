package com.fbm.schoolManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.fbm.schoolManagement.service.StudentService;
@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;	
	
	@GetMapping(value="/filterStudent/{classRoom}/{teacher}/{nbPage}/{sizePage}")
	public void filter(@PathVariable String classRoom, @PathVariable String teacher, @PathVariable int nbPage, @PathVariable int sizePage) {
		studentService.getStudents(classRoom,teacher,nbPage,sizePage);
	}

}
