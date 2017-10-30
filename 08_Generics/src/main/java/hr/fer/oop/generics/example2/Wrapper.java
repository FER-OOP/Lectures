package hr.fer.oop.generics.example2;

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
	}

