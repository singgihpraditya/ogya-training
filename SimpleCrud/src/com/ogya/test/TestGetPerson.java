package com.ogya.test;

import com.ogya.dao.PersonDAO;
import com.ogya.entity.Person;

public class TestGetPerson {
	public static void main(String[] args) {
		String id = "e429eb040ea346b8bea3990e8d52c625";

		PersonDAO personDao = new PersonDAO();
		Person person = personDao.getByIDStoreProcedure(id);
		System.out.println(person);
	}
}
