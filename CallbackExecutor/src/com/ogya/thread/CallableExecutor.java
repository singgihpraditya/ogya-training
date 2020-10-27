package com.ogya.thread;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableExecutor {
	public void executeThread() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		List<Person> personList = initiateData();

		List<CallableWorker> callableWorkers = new ArrayList<CallableWorker>();
		for (Person person : personList) {
			CallableWorker callableWorker = new CallableWorker(person);
			callableWorkers.add(callableWorker);
		}

		try {
			List<Future<Hashtable<String, String>>> futureList = executorService.invokeAll(callableWorkers);
			for (Future future : futureList) {
				Hashtable<String, String> result = (Hashtable<String,String>) future.get();
				System.out.println("Person with id : "+result.get("ID")+  ", status : "+result.get("STATUS"));
				
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	private List<Person> initiateData() {
		List<Person> list = new ArrayList<Person>();
		for (int i = 0; i < 100; i++) {
			Person person = new Person();
			person.setPersonId("" + i);
			person.setAddress("Address_" + i);
			person.setName("Name_" + i);
			list.add(person);
		}
		return list;
	}
	
	public static void main(String[] args){
		CallableExecutor callableExecutor = new CallableExecutor();
		callableExecutor.executeThread();
	}
}
