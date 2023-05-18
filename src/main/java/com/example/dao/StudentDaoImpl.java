package com.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Student;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {

	private SessionFactory sessionFactory;

	@Autowired
	public StudentDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createStudent(Student student) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(student);
		session.getTransaction().commit();
		System.out.println("done...");
	}

	@Override
	public Student updateStudent(int studentId, Student studentInput) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = session.get(Student.class, studentId);
		if (student == null) {
			System.out.println("student not found");
		} else {
			student.setFirstName(studentInput.getFirstName());
			student.setLastName(studentInput.getLastName());
			student.setEmail(studentInput.getEmail());
			session.update(student);
		}
		session.getTransaction().commit();
		return student;
	}

	@Override
	public Student getStudentById(int studentId) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student student = session.find(Student.class, studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {

		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("From Student");
		List<Student> list = query.getResultList();
		return list;
	}

	@Override
	public void deleteStudentById(int studentId) {

		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Student s = session.get(Student.class, studentId);
		if (s == null) {
			System.out.println("no such student found");
		} else {
			session.delete(s);
			System.out.println("student deleted");
			session.getTransaction().commit();
		}
	}

	@Override
	public void deleteAllStudents() {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Query query = session.createQuery("FROM Student", Student.class);
		List<Student> list = query.getResultList();
		for (Student s : list) {
			session.delete(s);
		}
		session.getTransaction().commit();

	}

}
