package hr.fer.oop.employees;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class EmployeeMain {

  public static void main(String[] args) {
    List<Employee> staff = new ArrayList<>();

    String input = "Marko Markovic;120000;1980;12;11\n" +
      "Pero Horvat;79000;1988;11;1\n" +
      "Tomislav Peric;40000;1990;3;10";

    try(Scanner scanner = new Scanner(input)) {
      while (scanner.hasNextLine()) {
        String strLine = scanner.nextLine();
        String[] inputData = strLine.split(";");
        staff.add(new Employee(
            inputData[0],
            Double.parseDouble(inputData[1]),
            Integer.parseInt(inputData[2]),
            Integer.parseInt(inputData[3]),
            Integer.parseInt(inputData[4])));
      }
    }

    printEmployees(staff, new JuniorEmployee());
    printEmployees(staff, new SeniorEmployee());
    // raise everyone's salary by 15%
    for(Employee e: staff)
      e.raiseSalary(15);

    printEmployees(staff, new JuniorEmployee());
    printEmployees(staff, new SeniorEmployee());

    // theMostSimilarEmployees
    theMostSimilarEmployees(staff, new SimilarEmployee());
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
      System.out.format("The most employees are: %n\t%s%n\t%s%n", similar1, similar2);
    }
  }
}
