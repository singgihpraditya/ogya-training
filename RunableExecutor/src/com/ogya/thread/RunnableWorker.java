package com.ogya.thread;

public class RunnableWorker implements Runnable {
	int threadNumber;
	
	public RunnableWorker(int threadNumber) {
		this.threadNumber = threadNumber;
	}
	
	@Override
	public void run() {
		System.out.println("Thread no : "+threadNumber);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
