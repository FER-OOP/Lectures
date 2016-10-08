package hr.fer.oop.generics.example1;

public class IntWrapper {
	private Integer value;
    public IntWrapper(Integer value) { 
       this.value = value; 
    }
    public Integer getValue() { return value; }
    public void setValue(Integer value) {
    	this.value = value; 
    }
    @Override
    public String toString() {    
      return value.toString();  
    }
}
