package com.ogya.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecutor {
	public void executeThread() {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 5; i++) {
			RunnableWorker runnableWorker = new RunnableWorker(i);
			executorService.execute(runnableWorker);
		}
	}
	
	public static void main(String[] args){
		RunnableExecutor runnableExecutor = new RunnableExecutor();
		runnableExecutor.executeThread();
	}
}
