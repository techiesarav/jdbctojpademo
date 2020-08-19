package com.in28mins.jdbctojpademo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in28mins.jdbctojpademo.jdbc.PersonJdbcDao;
import com.in28mins.jdbctojpademo.model.Person;

//@SpringBootApplication
public class JdbctojpademoApplication implements CommandLineRunner{
	
	Logger logger = LoggerFactory.getLogger(JdbctojpademoApplication.class);
	
	@Autowired
	PersonJdbcDao personJdbcDao;
	
	public static void main(String[] args) {
		Application context
//		SpringApplication.run(JdbctojpademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	/*	logger.info("Persons Objects =>{}",personJdbcDao.findAll());
		logger.info("Person with id =101 =>{}",personJdbcDao.findById(101));
		logger.info("Deleting the person with id=101 =>{}",personJdbcDao.deleteById(101));
		logger.info("inserting the new person obj={}",personJdbcDao.insertPerson(
				new Person(103,"sarav","chennai",new Date())));
		logger.info("update the person obj with id=102 =>{}",personJdbcDao.updatePerson(
				new Person(102,"viji","snkl",new Date())));*/
	}

}
