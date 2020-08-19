package com.in28mins.jdbctojpademo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Student {

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Id
	@GeneratedValue
	private Integer id;

	@Column(nullable=false)
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	@ManyToMany()
	@JoinTable(name="STUDENT_COURSE",
	joinColumns=@JoinColumn(name="STUDENT_ID"),
	inverseJoinColumns=@JoinColumn(name="COURSE_ID"))
	List<Course> courses = new ArrayList<>();

	public List<Course> getCourses() {
		return courses;
	}

	public void addCourse(Course course) {
		this.courses.add(course);
	}
	
	protected Student() {
		super();
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public Student(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
