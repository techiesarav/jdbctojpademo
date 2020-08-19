package com.in28mins.jdbctojpademo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Passport {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String number;
	
	protected Passport() {
		super();
	}
	
	public Integer getId() {
		return this.id;
	}
	
	public Passport(String number){
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}
}
