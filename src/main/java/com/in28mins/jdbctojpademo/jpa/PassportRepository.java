package com.in28mins.jdbctojpademo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in28mins.jdbctojpademo.model.Passport;

@Repository
@Transactional
public class PassportRepository {
	

	@Autowired
	EntityManager en;
	
	public List<Passport> findAll() {
		TypedQuery<Passport> PassportQuery = en.createNamedQuery("find_all_Passports",Passport.class);
		return PassportQuery.getResultList();
	}
	
	 public Passport findById(Long id) {
		return en.find(Passport.class, id);
	}
	 
	public void deleteById(Long id) {
		Passport c = en.find(Passport.class, id);
		en.remove(c);
	}
	
	public Passport savePassport(Passport c) {
		if(c.getId() == null) {
			en.persist(c);
		}else {
			en.merge(c);
		}
		return c;
	}
	
	public void playWithEntityManager() {
		Passport c = new Passport("webservices beginner");
		Passport c1 = new Passport("Angular beginner");
		//persist will only update the respective object with entity manager and wont run query
		en.persist(c);
		en.persist(c1);
		//Flush will run query and save to database
		en.flush();
		//If we exits out of method,due to @Transactional,query will run to
		//update the below name
		c.setNumber("webservices expert");
		//run select query and update the c object present in entity manager,
		//above setname wont get executed after method exit out of method
		en.refresh(c);
		//Entity manager wont keep track of the c object as it is detached
		//changes happed in c object wont get saved in db.
		en.detach(c);
	}
}
