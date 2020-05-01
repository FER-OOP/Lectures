package hr.fer.oop.employees;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class EmployeeMain {

  public static void main(String[] args) {
    List<Employee> staff = EmployeeLoader.loadFromFile("data.txt");

    printEmployees(staff, new JuniorEmployee());
    printEmployees(staff, new SeniorEmployee());

    // raise everyone's salary by 15%
    for(Employee e: staff)
      e.raiseSalary(15);

    // print junior
    printEmployees(staff, new Predicate<Employee>() {

      @Override
      public boolean test(Employee e) {
        return e.getSalary() < 80_000;
      }
    });

    // print senior
    printEmployees(staff, e -> e.getSalary() >= 80_000);

    // theMostSimilarEmployees
    theMostSimilarEmployees(staff, (a, b) -> (int) (Math.abs(a.getHireDate().toEpochDay() - b.getHireDate().toEpochDay())));
  }

  private static void printEmployees(Iterable<Employee> employees, Predicate<Employee> predicate) {
    for (Employee employee : employees) {
      if (predicate.test(employee)) {
        // print out information about all Employee objects
        System.out.println(employee);
      }
    }
  }

  public static void theMostSimilarEmployees(Iterable<Employee> employees,
      BiFunction<Employee, Employee, Integer> similarity) {

    Employee similar1 = null;
    Employee similar2 = null;
    int min = Integer.MAX_VALUE;

    for (Employee first : employees) {
      for (Employee second : employees) {
        if (first == second) {
          continue;
        }

        if (similar1 == null || similarity.apply(first, second) < min) {
          similar1 = first;
          similar2 = second;
          min = similarity.apply(first, second);
        }
      }
    }

    if (similar1 != null) {
      System.out.format("The most similar employees are: %n\t%s%n\t%s%n", similar1, similar2);
    }
  }
}
