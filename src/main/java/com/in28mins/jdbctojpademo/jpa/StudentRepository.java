package com.in28mins.jdbctojpademo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28mins.jdbctojpademo.model.Course;
import com.in28mins.jdbctojpademo.model.Passport;
import com.in28mins.jdbctojpademo.model.Student;

@Repository
@Transactional
//since transactional bound to class
//so persistence context is bounded around class 
public class StudentRepository {
	

	@Autowired
	EntityManager en;
	
	public List<Student> findAll() {
		TypedQuery<Student> StudentQuery = en.createNamedQuery("find_all_Students",Student.class);
		return StudentQuery.getResultList();
	}
	
	 public Student findById(Long id) {
		return en.find(Student.class, id);
	}
	 
	public void deleteById(Long id) {
		Student c = en.find(Student.class, id);
		en.remove(c);
	}
	
	public Student saveStudent(Student c) {
		if(c.getId() == null) {
			en.persist(c);
		}else {
			en.merge(c);
		}
		return c;
	}
	
	public void playWithEntityManager() {
		Student c = new Student("webservices beginner");
		Student c1 = new Student("Angular beginner");
		//persist will only update the respective object with entity manager and wont run query
		en.persist(c);
		en.persist(c1);
		//Flush will run query and save to database
		en.flush();
		//If we exits out of method,due to @Transactional,query will run to
		//update the below name
		c.setName("webservices expert");
		//run select query and update the c object present in entity manager,
		//above setname wont get executed after method exit out of method
		en.refresh(c);
		//Entity manager wont keep track of the c object as it is detached
		//changes happed in c object wont get saved in db.
		en.detach(c);
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("R000E01");
		en.persist(passport);
		Student student = new Student("raj");
		student.setPassport(passport);
		en.persist(student);
	}
	
	public void someOperationsToUnderstandPersistenceContext() {
		//Op 1 - get Student
		Student student=en.find(Student.class, 2000);
		//persistence Context (student)
		
		//Op2 - get Passport
		Passport passport = student.getPassport();
		//persistence Context (student,passport)
		
		//Op3 - update passport
		passport.setNumber("RT0001");
		//persistence Context (student,passport(modified))
		
		//Op4 - update student
		student.setName("raj");
		//persistence Context (student(modified),passport(modified))
		//saved to database from persistence context after exits from
		//method
	}
	
	public void insertStudentWithCourse(Student student,Course course) {
		student.addCourse(course);
		course.addStudent(student);
		en.persist(student);
		en.persist(course);
	}
}
