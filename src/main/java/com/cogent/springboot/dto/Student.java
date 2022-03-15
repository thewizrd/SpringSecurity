package com.cogent.springboot.dto;

/**
 * Student
 *
 * @author bryan
 * @date Mar 7, 2022-2:54:08 PM
 */
public class Student {
	private int studentID;
	private String studentName;

	public Student() {
		super();
	}

	public Student(int studentID, String studentName) {
		super();
		this.studentID = studentID;
		this.studentName = studentName;
	}

	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
}
