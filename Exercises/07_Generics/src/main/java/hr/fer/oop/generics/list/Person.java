package hr.fer.oop.generics.list;

import java.util.Date;

public class Person {
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
		return op.getOIB().equals(this.OIB);
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
