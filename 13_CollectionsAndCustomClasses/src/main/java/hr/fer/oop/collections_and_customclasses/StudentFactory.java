package hr.fer.oop.collections_and_customclasses;

public interface StudentFactory <S> {
	S  create(String firstName, String lastName, String studentID);
}