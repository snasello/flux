package fr.snasello.flux;

public class Flux<T> {
	
	private final ActionConsumer<T> consumer;
	
	private final ActionProducer<T> producer;

	private final Tunnel<T> tunnel;
	
	public Flux(ActionConsumer<T> consumer, ActionProducer<T> producer, Tunnel<T> tunnel){
		this.consumer = consumer;
		this.producer = producer;
		this.tunnel = tunnel;
	}
	
	public void stop(){
		tunnel.stop();
	}
	
	public void start() throws InterruptedException{
		tunnel.start();
		producer.start(tunnel);
		consumer.start(tunnel);
	}
}
