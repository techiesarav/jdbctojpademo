package com.in28mins.jdbctojpademo.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.in28mins.jdbctojpademo.SpringJpaDatabaseApplication;
import com.in28mins.jdbctojpademo.model.Course;
import com.in28mins.jdbctojpademo.model.Review;
import com.in28mins.jdbctojpademo.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=SpringJpaDatabaseApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	EntityManager en;
	
	/*@Test
	public void findById_test() {
		Course course =courseRepository.findById(10000L);
		logger.info("Find By Id =10000 =>{}",course);
		assertEquals("JPA in Depth",course.getName());
	}*/
	
	@Test
	@DirtiesContext
	public void deleteById_test() {
		courseRepository.deleteById(10001L);
		assertNull(courseRepository.findById(10001L));
	}
	
	@Test
	@DirtiesContext
	public void save_test() {
		Course course =courseRepository.findById(10000L);
		assertEquals("JPA in Depth",course.getName());
		course.setName("JPA in Depth v2");
		courseRepository.save(course);
		Course c1 =courseRepository.findById(10000L);
		assertEquals("JPA in Depth v2",c1.getName());
	}
	
	@Test
	@DirtiesContext
	public void entity_test() {
		courseRepository.playWithEntityManager();
	}
	
	@Test
	@DirtiesContext
	public void check_column() {
		Course c1 = new Course(null);
		courseRepository.save(c1);
	}
	
	@Test
	@Transactional
	public void getReviewsForCourse() {
		Course c1 = courseRepository.findById(10000L);
		logger.info("Course =>{}",c1);
		logger.info("Reviews =>{}",c1.getReviews());
	} 

	@Test
	@Transactional
	public void getCourseForReview() {
		Review r1 = en.find(Review.class,4000);
		logger.info("review =>{}",r1);
		logger.info("Reviews =>{}",r1.getCourse());
	}
	
	@Test
	@Transactional
	public void retreiveCourseWithStudent() {
		Course course =en.find(Course.class, 10000L);
		logger.info("course =>{}",course);
		logger.info("students =>{}",course.getStudents());
	}
}
