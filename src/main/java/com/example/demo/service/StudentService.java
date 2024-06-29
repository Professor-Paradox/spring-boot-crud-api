package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	// save single student directly with / api call
	public Student addStudent(Student student) {
		return studentRepository.save(student);
	}

	// save list of students directly with /bulk api call
	public List<Student> addStudents(List<Student> students) {
		return studentRepository.saveAll(students);
	}

	// get single student with there id /{id} api call
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id).orElse(null);
	}

	// get all students list with / api call
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	// update a single user directly with there respective id present in the api
	// call and json data
	// /{id} api call
	public Student updateStudent(Integer id, Student student) {
		Optional<Student> existingStudent = studentRepository.findById(id);
		if (existingStudent.isPresent()) {
			studentRepository.save(student);
			return student;
		} else {
			return null;
		}
	}

//        the update data should be in this format to avoid errors of creating new users instead of updating existing ones 
//        make sure give the object original id and new data you want
//        example to change the id 3 user with new data
//        {
//            "id":3,
//           "roll_no": "2023102",
//           "branch": "Electrical Engineering",
//           "full_name": "BSmith",
//           "email": "bobby.smith@example.com",
//           "phone_number": "9876543210"
//        }

	public Student deleteStudent(Integer id) {
		Optional<Student> existingStudent = studentRepository.findById(id);
		if (existingStudent.isPresent()) {
			Student student = existingStudent.get();
			studentRepository.delete(student);
			return student;
		}
		return null;
	}

	public List<Student> findByRollNo(String rollNo) {
		return this.studentRepository.findByRollNo(rollNo);
	}

}