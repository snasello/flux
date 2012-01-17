package fr.snasello.flux;

public abstract class Traitement<T> {

	private java.util.List<Condition<T>> conditions;
	
	public void addCondition(Condition<T> condition){
		if(this.conditions == null){
			this.conditions = new java.util.LinkedList<Condition<T>>();
		}
		this.conditions.add(condition);
	}
	
	public boolean test(T data){
		if(conditions == null){
			return true;
		}
		for(Condition<T> condition : conditions){
			if(condition.test(data)){
				return true;
			}
		}
		return false;
	}
	
	public abstract void execute(T data);

}
