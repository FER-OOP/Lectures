package hr.fer.oop.task1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SharedData {
	int id = 0;
	private boolean gameOver = false;
	private BlockingQueue<String> airQueue;
	private BlockingQueue<String> queue;

	public SharedData(int noOfEmployees){		
		airQueue = new ArrayBlockingQueue<>(1);
		queue = new ArrayBlockingQueue<>(noOfEmployees);
	}
	
	//metoda nextId vraća sljedeći redni broj natjecatelja
	public synchronized int nextId(){
		++id;
		return id;
	}
	
	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public BlockingQueue<String> getAirQueue() {
		return airQueue;
	}

	
	public BlockingQueue<String> getQueue() {
		return queue;
	}
}
