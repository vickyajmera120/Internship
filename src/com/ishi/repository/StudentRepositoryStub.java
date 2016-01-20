package com.ishi.repository;

import java.sql.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.ishi.model.Student;

public class StudentRepositoryStub {

		@SuppressWarnings("unused")
		private DataSource dataSource;
		private JdbcTemplate jdbcTemplateObject;

		public void setDataSource(DataSource dataSource) {
			this.dataSource = dataSource;
			this.jdbcTemplateObject = new JdbcTemplate(dataSource);
		}

		//Register the student and make entry in the database
		public void create(Student student) {
			String SQL = "INSERT INTO `Internship`.`student` (`first_name`, `last_name`, `dob`,"
					+ " `email`, `mobile`, `address`, `city`, `pincode`, `state`, `country`, `courses`)"
					+"VALUES (?,?,?,?,?,?,?,?,?,?,?)";
			
			int id = student.getId();
			String firstName = student.getFirstName();
			String lastName = student.getLastName();
			Date dob = student.getDob();
			String email = student.getEmail();
			String mobile = student.getMobile();
			String address = student.getAddress();
			String pincode = student.getPincode();
			String city = student.getCity();
			String state = student.getState();
			String country = student.getCountry();
			String courses = student.getCourses();
			
			//jdbcTemplateObject.update(SQL, student);
			jdbcTemplateObject.update(SQL, firstName, lastName, dob, email, mobile, address, city, pincode, state, country, courses);
			System.out.println("Created Record: \tName = " + firstName);
			return;
		}

		public Student getStudent(Integer id) {
			String SQL = "select * from Student where id = ?";
			Student student = jdbcTemplateObject.queryForObject(SQL, new Object[] { id }, new StudentMapper());
			return student;
		}

		public List<Student> listStudents() {
			String SQL = "select * from Student";
			List<Student> students = jdbcTemplateObject.query(SQL, new StudentMapper());
			return students;
		}

		//Delete the student account having ID=id
		public void delete(Integer id) {
			String SQL = "delete from `student` where id = ?";
			jdbcTemplateObject.update(SQL, id);
			System.out.println("Deleted Record with ID = " + id);
			return;
		}

		public void update(Integer id, Integer age) {
			String SQL = "update student set age = ? where id = ?";
			jdbcTemplateObject.update(SQL, age, id);
			System.out.println("Updated Record with ID = " + id);
			return;
		}
	
}
