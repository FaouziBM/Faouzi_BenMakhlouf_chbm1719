package com.fbm.schoolManagement.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fbm.schoolManagement.repository.StudentRepository;
import com.fbm.schoolManagement.entity.Student;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class StudentService {
	
	final StudentRepository studentRepo;
	
	public StudentService(StudentRepository studentRepo) {
		super();
		this.studentRepo = studentRepo;
	}
	
	public Page<Student> getStudents(String classRoom, String teacher, int nbPage, int sizePage){

		Pageable pageable = PageRequest.of(nbPage, sizePage, Sort.by("classRoom"));
		
		if (!classRoom.trim().equals("") || !teacher.trim().equals("")) {
			return studentRepo.findByClassRoomNameAndClassRoomTeacherFirstName(classRoom, teacher, pageable);
		} else {
			return studentRepo.findAll(pageable);
		}
	}

}
