package com.ogya.test;

import java.util.List;

import com.ogya.dao.PersonDAO;
import com.ogya.entity.Person;

public class TestGetAll {
	public static void main(String[] args){
		PersonDAO personDao = new PersonDAO();
		List<Person> personList = personDao.getAll();
		for(Person person : personList){
			System.out.println("Person : "+person.toString());
		}
	}
}
