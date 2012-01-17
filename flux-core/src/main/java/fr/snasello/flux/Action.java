package fr.snasello.flux;

public abstract class Action<T>{
	
	public abstract void start(Tunnel<T> tunnel) throws InterruptedException;
}
