package com.in28mins.jdbctojpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.in28mins.jdbctojpademo.jpa.CourseRepository;
import com.in28mins.jdbctojpademo.jpa.PassportRepository;
import com.in28mins.jdbctojpademo.jpa.PersonJpaRepository;
import com.in28mins.jdbctojpademo.jpa.StudentRepository;
import com.in28mins.jdbctojpademo.model.Course;
import com.in28mins.jdbctojpademo.model.Student;



@SpringBootApplication
@ComponentScan(basePackages="com.in28mins.jdbctojpademo")
public class SpringJpaDatabaseApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(JdbctojpademoApplication.class);
	
	@Autowired
	PersonJpaRepository personJpaRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	PassportRepository passportRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
/*		logger.info("Person with id =101 =>{}",personJpaRepository.findById(101));
		logger.info("inserting the new person obj={}",personJpaRepository.updatePerson(
				new Person(103,"sarav","chennai",new Date())));
		logger.info("update the person obj with id=102 =>{}",personJpaRepository.updatePerson(
				new Person(102,"viji","snkl",new Date())));
		logger.info("Deleting the person with id=101");
		personJpaRepository.deleteById(101);
		logger.info("Persons Objects =>{}",personJpaRepository.findAll());*/
//		logger.info("Course with id =10000 =>{}",courseRepository.findById(10000L));
//		courseRepository.playWithEntityManager();
		//OneToOne Check
		//studentRepository.saveStudentWithPassport();
		//ManyToOne || OneToMany Check
		/*List<Review> reviews = new ArrayList<>();
		Review review1 = new Review(4,"Gud");
		Review review2 = new Review(3,"Fair");
		reviews.add(review1);
		reviews.add(review2);
		courseRepository.saveReviewsForCourse(10000L,reviews);*/
		//ManyToMany Check
		studentRepository.insertStudentWithCourse(new Student("viji"),
				new Course("Deep Learning"));
	}

}
