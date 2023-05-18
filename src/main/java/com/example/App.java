package com.example;

import java.util.Random;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.config.SpringConfig;
import com.example.model.Instrutor;
import com.example.model.Student;
import com.example.service.InstructorService;
import com.example.service.InstructorServiceImpl;
import com.example.service.StudentService;
import com.example.service.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App {

	static int choice = 0;
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

		StudentService studentService = context.getBean("studentService", StudentServiceImpl.class);
		InstructorService instructorService = context.getBean("instructorService", InstructorServiceImpl.class);

		do {
			System.out.println("1. create Student");
			System.out.println("2. update student");
			System.out.println("3. get student by id");
			System.out.println("4. get all students");
			System.out.println("5. delete student by id");
			System.out.println("6. delete all students");
			System.out.println("7. create instructor");
			System.out.println("enter your choice");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Student student = new Student();
				student.setStudentId(new Random().nextInt());
				System.out.println("Enter Student FirstName");
				student.setFirstName(scanner.next());
				System.out.println("Enter Student last name");
				student.setLastName(scanner.next());
				System.out.println("Enter Email");
				student.setEmail(scanner.next());
				studentService.createStudent(student);
				break;
			case 2:
				Student s = new Student();
				System.out.println("Enter Student id");
				s.setStudentId(scanner.nextInt());
				System.out.println("Enter Student FirstName");
				s.setFirstName(scanner.next());
				System.out.println("Enter Student last name");
				s.setLastName(scanner.next());
				System.out.println("Enter Email");
				s.setEmail(scanner.next());
				studentService.updateStudent(s.getStudentId(), s);
				break;
			case 3:
				System.out.println("enter student id");
				Student s1 = studentService.getStudentById(scanner.nextInt());
				System.out.println(s1);
				break;
			case 4:
				System.out.println("get all the students");
				System.out.println(studentService.getAllStudents());
				break;
			case 5:
				System.out.println("delete student by id");
				System.out.println("enter student id to delete");
				studentService.deleteStudentById(scanner.nextInt());
				break;
			case 6:
				studentService.deleteAllStudents();
				break;
			case 7:
				Instrutor instrutor = new Instrutor();
				System.out.println("Enter Instrctor Name");
				instrutor.setInstructorName(scanner.next());
				System.out.println("Enter instructor rating");
				instrutor.setInstructorRating(scanner.nextInt());
				instructorService.createInstrutor(instrutor);
				break;
			}
		} while (choice != 0);

	}
}
