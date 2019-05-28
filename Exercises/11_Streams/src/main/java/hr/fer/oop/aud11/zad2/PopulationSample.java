package hr.fer.oop.aud11.zad2;

import java.lang.String;

public class PopulationSample {
	private String fileName;
	private String label;
	private Integer age;
	
	public PopulationSample(String fileName, String label, Integer age) {
		this.fileName = fileName;
		this.label = label;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return String.format("PopulationSample(Name: %s, Age: %s, Label: %s)", this.fileName, this.age, this.label);
	}
	
	public String getFileName() {
		return this.fileName;
	}
	
	public String getLabel() {
		return this.label;
	}
	
	public Integer getAge() {
		return this.age;
	}
}
