package com.example.dao;

import java.util.List;

import com.example.model.Student;

public interface StudentDao {
	public void createStudent(Student student);

	public Student updateStudent(int studentId, Student studentInput);

	public Student getStudentById(int studentId);

	public List<Student> getAllStudents();

	public void deleteStudentById(int studentId);

	public void deleteAllStudents();

}
