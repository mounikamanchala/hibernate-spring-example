package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.StudentDao;
import com.example.model.Student;

@Component("studentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	@Override
	public void createStudent(Student student) {
		studentDao.createStudent(student);
	}

	@Override
	public Student updateStudent(int studentId, Student studentInput) {

		return studentDao.updateStudent(studentId, studentInput);
	}

	@Override
	public Student getStudentById(int studentId) {
		return studentDao.getStudentById(studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	public void deleteStudentById(int studentId) {
		studentDao.deleteStudentById(studentId);
	}

	@Override
	public void deleteAllStudents() {
		studentDao.deleteAllStudents();
	}

}
