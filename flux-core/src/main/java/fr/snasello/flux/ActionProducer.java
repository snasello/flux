package fr.snasello.flux;

public abstract class ActionProducer<T> extends Action<T> {
	
	@Override
	public final void start(Tunnel<T> tunnel) throws InterruptedException{
		produce(tunnel);
	}
	
	protected abstract void produce(Tunnel<T> tunnel);

}
