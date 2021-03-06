package com.ishi.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.ishi.client.StudentClient;
import com.ishi.model.Student;
import com.ishi.repository.StudentRepository;

public class StudentRepositoryTest {

	//ApplicationContext context = new ClassPathXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/Beans.xml");
	ApplicationContext context = new FileSystemXmlApplicationContext("file:src/main/webapp/WEB-INF/spring/Beans.xml");
	
	StudentRepository studentRepository = (StudentRepository) context.getBean("studentRepositoryStub");
	
	@Test
	public void testCreate() {
		System.out.println("------Records Creation--------");
		Student student = new Student();
		
		student.setFirstName("Dilip");
		student.setLastName("Mirchandani");
		
		studentRepository.create(student);
		System.out.println();
	}
	
	@Test
	public void testDelete() {
		StudentClient client = new StudentClient();
		
		client.delete(13);
	
		//studentRepository.delete(15);
	}
	
	@Test
	public void testRead() {
		
		System.out.println("----Listing Record with ID =  -----");
		
		Student student = studentRepository.getStudent("15");
		System.out.println("ID : " + student.getId());
		System.out.println("First Name : " + student.getFirstName());
		System.out.println("Last Name : " + student.getLastName());
		System.out.println();
	}
	
}
