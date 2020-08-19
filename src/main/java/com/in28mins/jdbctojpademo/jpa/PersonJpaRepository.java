package com.in28mins.jdbctojpademo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28mins.jdbctojpademo.model.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	@PersistenceContext
	EntityManager en;
	
	public Person findById(int id) {
		return en.find(Person.class,id);
	}
	
	public Person updatePerson(Person p) {
		return en.merge(p);
	}
	
	public List<Person> findAll(){
		TypedQuery<Person> namedQuery = en.createNamedQuery("find_all_persons",Person.class);
		return namedQuery.getResultList();
	}
	public void deleteById(int id) {
		Person p= en.find(Person.class,id);
		en.remove(p);
	}
	
}
