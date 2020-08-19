package com.in28mins.jdbctojpademo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.in28mins.jdbctojpademo.model.Course;
import com.in28mins.jdbctojpademo.model.Review;

@Repository
@Transactional
public class CourseRepository implements BeanPostProcessor {
	
	Logger logger = LoggerFactory.getLogger(CourseRepository.class);
	
	@Autowired
	EntityManager en;
	
	public List<Course> findAll() {
		TypedQuery<Course> courseQuery = en.createNamedQuery("find_all_courses",Course.class);
		return courseQuery.getResultList();
	}
	
	 public Course findById(Long id) {
		return en.find(Course.class, id);
	}
	 
	public void deleteById(Long id) {
		Course c = en.find(Course.class, id);
		en.remove(c);
	}
	
	public Course save(Course c) {
		if(c.getId() == null) {
			en.persist(c);
		}else {
			en.merge(c);
		}
		return c;
	}
	
	public void playWithEntityManager() {
		Course c = new Course("webservices beginner");
		Course c1 = new Course("Angular beginner");
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

	public void saveReviewsForCourse(Long courseId, List<Review> reviews) {
		//Get Course 
		Course course = en.find(Course.class, courseId );
		//get Reviews
		logger.info("Reviews =>{}",course.getReviews());
		for(Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			en.persist(review);
		}
	}
}
