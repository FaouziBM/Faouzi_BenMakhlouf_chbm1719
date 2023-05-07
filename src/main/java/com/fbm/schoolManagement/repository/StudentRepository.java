package com.fbm.schoolManagement.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fbm.schoolManagement.entity.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    Optional<Student> findById(Long idStudent);
    List<Student> findByClassRoomNameAndClassRoomTeacherFirstName(String classRoom ,String teacher);
    Page<Student> findByClassRoomNameAndClassRoomTeacherFirstName(String classRoom ,String teacher, Pageable pageable);
    List<Student> findAll();
    Page<Student> findAll(Pageable pageable);
}
