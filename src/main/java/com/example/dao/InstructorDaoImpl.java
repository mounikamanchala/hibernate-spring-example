package com.example.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Instrutor;

@Component("instructorDao")
public class InstructorDaoImpl implements InstructorDao{

	private SessionFactory sessionFactory;

	@Autowired
	public InstructorDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void createInstrutor(Instrutor instrutorInput) {
		Session session= sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(instrutorInput);
		session.getTransaction().commit();
	}

}
