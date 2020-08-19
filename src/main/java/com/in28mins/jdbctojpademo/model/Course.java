package com.in28mins.jdbctojpademo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQuery(name="find_all_courses",query="select c from Course c")
public class Course {

    @Id
    @GeneratedValue
	private Long id;
  
    @Column(name="name",nullable=false)
    private String name;
    
    @CreationTimestamp
    private LocalDateTime createdDate;
    
    @UpdateTimestamp
    private LocalDateTime updatedDate;
    
    @OneToMany(mappedBy="course")
    List<Review> reviews = new ArrayList<>();
    
    @ManyToMany(mappedBy="courses")
    List<Student> students = new ArrayList<>();
    
    public List<Student> getStudents() {
		return students;
	}

	public void addStudent(Student student) {
		this.students.add(student);
	}

	public void addReview(Review review) {
    	this.reviews.add(review);
    }
    
    public void removeReview(Review review) {
    	this.reviews.remove(review);
    }
    
    public List<Review> getReviews() {
		return reviews;
	}

	protected Course() {
    	super();
    }

	public Course(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String course) {
		this.name = course;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", course=" + name + "]";
	}
}
