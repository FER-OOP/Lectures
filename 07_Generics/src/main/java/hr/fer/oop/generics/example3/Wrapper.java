package hr.fer.oop.generics.example3;

public class Wrapper<T> {
	  private T value;
	  public Wrapper() {
	    this.value = null;
	  }
	  public Wrapper(T value) {
	    this.value = value;
	  }
	  public T getValue() {
	    return value;
	  }
	  public void setValue(T value) {
	    this.value = value;
	  }	  
	  @Override
	  public String toString() {
	    if(value==null) return "";
	    return value.toString();
	  }
	  
	  public <V> void printWith(V another){
		  System.out.format("first: %s second %s %n", this.toString(), another.toString());
	  }
	  
	  public void printWithWrapper(Wrapper<?> another){
		  System.out.format("first: %s second %s %n", this.toString(), another.getValue().toString());
	  }
	}

