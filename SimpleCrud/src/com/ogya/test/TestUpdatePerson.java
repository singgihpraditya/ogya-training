package com.ogya.test;

import com.ogya.dao.PersonDAO;
import com.ogya.entity.Person;

public class TestUpdatePerson {
	public static void main(String[] args) {

		Person person = new Person();
		person.setId("f4bca2644bc1465ea1b6aa3e8d83b5fb");
		person.setFirstName("Singgih");
		person.setLastName("Praditya");
		person.setPosition("Developer");
		person.setAddress("Bogor");
		
		PersonDAO personDao = new PersonDAO();
		personDao.updatePerson(person);
	}
}
