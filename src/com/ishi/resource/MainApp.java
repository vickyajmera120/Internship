package com.ishi.resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ishi.model.Student;
import com.ishi.repository.StudentRepositoryStub;;

public class MainApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

		StudentRepositoryStub studentRepository = (StudentRepositoryStub) context.getBean("studentRepositoryStub");
		
		
		
		System.out.println("------Records Creation--------");
		Student student = new Student();
		
		student.setFirstName("Raghav");
		student.setLastName("Thirani");
		
		studentRepository.create(student);
		System.out.println();
		
		
		

		
		/*
		System.out.println("------Listing Multiple Records--------");
		List<Student> students = studentRepository.listStudents();
		for (Student record : students) {
			System.out.print("ID : " + record.getId());
		}
		System.out.println();

		System.out.println("----Updating Record with ID = 2 -----");
		studentRepository.update(2, 20);

		System.out.println();
		
//		System.out.println("----Listing Record with ID = 2 -----");
//		
//		Student student = studentJDBCTemplate.getStudent(2);
//		System.out.print("ID : " + student.getId());
//		System.out.print(", Name : " + student.getName());
//		System.out.println(", Age : " + student.getAge());
		 */
	}
}