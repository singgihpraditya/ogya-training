package com.ogya.thread;

import java.util.Hashtable;
import java.util.concurrent.Callable;

//Hasil List<Future<Hashtable<String, String>>>
public class CallableWorker implements Callable<Hashtable<String, String>> {
	private Person person;

	public CallableWorker(Person person) {
		this.person = person;
	}

	@Override
	//Future<Hashtable<String, String>>
	public Hashtable<String, String> call() throws Exception {
		System.out.println("Execute : " + person.toString());
		
		Hashtable<String, String> result = new Hashtable<String, String>();
		result.put("ID",person.getPersonId());
		if (Integer.parseInt(person.getPersonId()) % 2 == 0) {
			result.put("STATUS","Success");
		} else {
			result.put("STATUS","Failed");
		}
		
		Thread.sleep(1000);
		return result;
	}
}
