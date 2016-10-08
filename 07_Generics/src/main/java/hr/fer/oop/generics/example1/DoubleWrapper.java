package hr.fer.oop.generics.example1;

public class DoubleWrapper {
	private Double value;
    public DoubleWrapper(Double value) { 
       this.value = value; 
    }
    public Double getValue() { return value; }
    public void setValue(Double value) {
    	this.value = value; 
    }
    @Override
    public String toString() {    
      return value.toString();  
    }
}
