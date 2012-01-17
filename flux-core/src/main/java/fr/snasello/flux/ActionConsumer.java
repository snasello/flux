package fr.snasello.flux;

public abstract class ActionConsumer<T> extends Action<T>{

	@Override
	public final void start(Tunnel<T> tunnel) throws InterruptedException{
		T data = tunnel.consume();
		consume(data);
	}
	
	protected abstract void consume(T data);
}
