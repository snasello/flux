package fr.snasello.flux;

import java.util.concurrent.TimeUnit;

public final class Tunnel<T> {

	private static final long TIMEOUT_VALUE = 5L;

	private static final TimeUnit TIMEOUT_TIMEUNIT = TimeUnit.SECONDS;

	private java.util.concurrent.BlockingQueue<T> queue;

	private boolean stopped;
	
	public void produce(T data) throws InterruptedException {
		this.queue.put(data);
	}

	public T consume() throws InterruptedException {
		T data = null;
		while(!this.stopped && data == null){
			data = this.queue.poll(TIMEOUT_VALUE, TIMEOUT_TIMEUNIT);
		}
		return data;
	}
	
	public void start(){
		this.stopped = false;
		this.queue = new java.util.concurrent.LinkedBlockingQueue<T>();
	}
	
	public void stop(){
		this.stopped = true;
	}
}
