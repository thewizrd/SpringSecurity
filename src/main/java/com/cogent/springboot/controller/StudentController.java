package com.cogent.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.springboot.dto.Student;

/**
 * StudentController
 *
 * @author bryan
 * @date Mar 7, 2022-2:52:06 PM
 */
@RestController
@RequestMapping("student")
public class StudentController {

	private static final List<Student> STUDENTS = Arrays.asList(new Student(1, "Jayant"), new Student(2, "Samrit"),
			new Student(3, "Rudransh"), new Student(4, "Samrat"), new Student(5, "Shivansh"));

	@GetMapping("{studentID}")
	public Student getStudent(@PathVariable("studentID") Integer studentID) {
		return STUDENTS.stream().filter(s -> {
			return s.getStudentID() == studentID;
		}).findFirst().orElseThrow(() -> {
			return new IllegalStateException("Student with ID: " + studentID + " does not exist");
		});
	}
}
