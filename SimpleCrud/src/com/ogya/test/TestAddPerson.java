package com.ogya.test;

import java.util.UUID;

import com.ogya.dao.PersonDAO;
import com.ogya.entity.Person;

public class TestAddPerson {
	public static void main(String[] args) {
		Person person = new Person();
		person.setId(UUID.randomUUID().toString().replace("-", ""));
		person.setFirstName("Singgih");
		person.setLastName("Praditya");
		person.setPosition("Developer");
		person.setAddress("Jakarta");
		
		PersonDAO personDao = new PersonDAO();
		personDao.addPerson(person);
	}
}
