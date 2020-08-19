package com.in28mins.jdbctojpademo.jdbc;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.in28mins.jdbctojpademo.model.Person;

@Repository
public class PersonJdbcDaoImpl implements PersonJdbcDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class));
	}

	public Person findById(int id) {
		return jdbcTemplate.queryForObject("select * from person where id=?",
				new Object[] {id},new BeanPropertyRowMapper<Person>(Person.class));
	}

	public int deleteById(int id) {
		return jdbcTemplate.update("delete from person where id=?",new Object[] {id});
	}

	public int insertPerson(Person p) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("insert into person values(?,?,?,?)",new Object[] {
				p.getId(),
				p.getName(),
				p.getLocation(),
				new Timestamp(p.getBirthDate().getTime())
		});
	}
	
	public int updatePerson(Person p) {
		// TODO Auto-generated method stub
		return jdbcTemplate.update("update person "
				+ "set name =?,location=?,birth_date=? where id=?",new Object[] {
				p.getName(),
				p.getLocation(),
				new Timestamp(p.getBirthDate().getTime()),
			    p.getId()});
	}	
}
