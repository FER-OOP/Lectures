package hr.fer.oop.collections_and_customclasses;

public interface StudentFactory <S> {
	S  create(String lastName, String firstName, String studentID);
}