package com.ogya.test;

import com.ogya.dao.PersonDAO;

public class TestDeletePerson {
	public static void main(String[] args) {
		String id = "f4bca2644bc1465ea1b6aa3e8d83b5fb";

		PersonDAO personDao = new PersonDAO();
		personDao.deletePerson(id);
	}
}
