package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByRollNo(String rollNo);	
	// extra function declaration that can search students based on there roll no
	
}