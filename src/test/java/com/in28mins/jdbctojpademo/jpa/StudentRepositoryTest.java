package com.in28mins.jdbctojpademo.jpa;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.internal.runners.statements.Fail;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28mins.jdbctojpademo.SpringJpaDatabaseApplication;
import com.in28mins.jdbctojpademo.model.Passport;
import com.in28mins.jdbctojpademo.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringJpaDatabaseApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);
	
	@Autowired
	EntityManager em;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Test
	@Transactional
	public void findById_test() {
		Student student =em.find(Student.class, 2000);
		logger.info("Find By Id =2000 =>{}",student);
		logger.info("Passport ={}",student.getPassport());
	}
	
	
	@Test
	@Transactional
	public void save_test() {
		Passport passport = new Passport("R000E01");
		em.persist(passport);
		Student student = new Student("raj");
		student.setPassport(passport);
		em.persist(student);
	}
	
	@Test
	@Transactional
	public void retrieveStudentAndPassport() {
		Student student=em.find(Student.class, 2000);
		logger.info("stdent info ->{}",student);
		logger.info("passport info->{}",student.getPassport());
	}
	
	@Test
	public void someOperationsToUnderstandPersistenceContext() {
		studentRepository.someOperationsToUnderstandPersistenceContext();
	}
	
	@Test
	@Transactional
	public void retreiveStudentWithCourse() {
		Student student =em.find(Student.class, 2000);
		logger.info("student =>{}",student);
		logger.info("courses =>{}",student.getCourses());
	}

}
