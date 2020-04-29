package hr.fer.oop.employees;

import java.util.function.BiFunction;

class SimilarEmployee implements BiFunction<Employee, Employee, Integer> {
  @Override
  public Integer apply(Employee a, Employee b) {
    return (int) (Math.abs(a.getHireDay().toEpochDay() - b.getHireDay().toEpochDay()));
  }
}