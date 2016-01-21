package com.ishi.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ishi.model.Student;
import com.ishi.repository.StudentRepositoryStub;

public class StudentRepositoryTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");

	StudentRepositoryStub studentRepository = (StudentRepositoryStub) context.getBean("studentRepositoryStub");

	@Test
	public void testCreate() {
		System.out.println("------Records Creation--------");
		Student student = new Student();
		
		student.setFirstName("Aaditya");
		student.setLastName("Gogia");
		
		studentRepository.create(student);
		System.out.println();
	}
	
	@Test
	public void testDelete() {
		studentRepository.delete(14);
	}
	
}
