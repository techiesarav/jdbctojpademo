package com.in28mins.jdbctojpademo.jdbc;

import java.util.List;

import com.in28mins.jdbctojpademo.model.Person;


public interface PersonJdbcDao {
	
	public List<Person> findAll();
	
	public Person findById(int id);
	
	public int deleteById(int id);
	
	public int insertPerson(Person p);
	
	public int updatePerson(Person p);
}
