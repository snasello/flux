package fr.snasello.flux;

public interface Condition<T> {

	boolean test(T data);
}
