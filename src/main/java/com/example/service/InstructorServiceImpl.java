package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.InstructorDao;
import com.example.model.Instrutor;

@Component("instructorService")
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	private InstructorDao instructorDao;

	@Override
	public void createInstrutor(Instrutor instrutor) {
		instructorDao.createInstrutor(instrutor);
	}

}
