package hr.fer.oop.generics.sorted;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Person implements Comparable<Person> {
	private String OIB,name,surname;
	private Date birthDate;
	private Integer height;
	
	public Person(String OIB,String name,String surname,Date birthDate,Integer height) {
		this.OIB=OIB;
		this.name=name;
		this.surname=surname;
		this.birthDate=birthDate;
		this.height=height;
	}
	public Person() {
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!obj.getClass().equals(this.getClass())) return(false);
		Person op=(Person)obj;
		// two person objects are the same only if their OIB property have the same value
		return op.getOIB().equals(this.OIB);
	}
	
	public int compareTo(Person o) {
		// java.util.Date is already implementing Comparable interface, so we only return the result back
		// this is actually comparing two birth dates for the sorting method
		return(this.birthDate.compareTo(o.getBirthDate()));
	}
	
	@Override
	public String toString() {
		// Croatian date format
		SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy.");
		StringBuilder sb=new StringBuilder();
		// Print the person details
		sb.append("Person = OIB:").append(this.OIB).append(", Name:").append(this.name).append(", Surname:").append(this.surname);
		sb.append(", Date of birth:").append(sdf.format(this.birthDate));
		return sb.toString();
	}

	public String getOIB() {
		return OIB;
	}

	public void setOIB(String oIB) {
		OIB = oIB;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}
}
