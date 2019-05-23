package hr.fer.oop.zad3;

public class Person implements Comparable<Person> {
	private String oib;
	private String firstName;
	private String surname;
	private int age;
	private String status;
	
	public Person(String oib, String firstName, String surname, int age, String status) {
		this.oib = oib;
		this.firstName = firstName;
		this.surname = surname;
		this.age = age;
		this.status = status;
	}

	@Override
	public int hashCode() {
		return ((this.oib == null) ? 0 : this.oib.hashCode());
	}
	
	@Override
	 public boolean equals(Object obj) {
		if (obj instanceof Person) {
			Person person = (Person) obj;
			return ((this.oib == null) ? false : this.oib.equals(person.oib));
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Person o) {
		return this.getOib().compareTo(o.getOib());
	}

	public String getOib() {
		return oib;
	}

	public void setOib(String oib) {
		this.oib = oib;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Person [oib=" + oib + ", firstName=" + firstName + ", surname=" + surname + ", age=" + age + ", status="
				+ status + "]";
	}
}
