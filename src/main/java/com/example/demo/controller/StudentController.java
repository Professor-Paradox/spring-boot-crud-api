package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.demo.model.*;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}

	@PostMapping("/bulk")
	public List<Student> addStudents(@RequestBody List<Student> students) {
		return studentService.addStudents(students);
	}

	@GetMapping
	public List<Student> getAllStudents() {
		return studentService.getAllStudents();
	}

	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable Integer id) {
		return studentService.getStudentById(id);
	}

	@PutMapping("/{id}")
	public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public Student deleteStudent(@PathVariable Integer id) {
		return studentService.deleteStudent(id);
	}

	@GetMapping("/search")
	public List<Student> findByRollNo(@RequestParam String rollNo) {
		return studentService.findByRollNo(rollNo);
	}

	// use the above in this format to search for user with rollno
	// http://localhost:8080/api/student/search?rollNo=1234500001

}