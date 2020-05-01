package hr.fer.oop.employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader {
  public static List<Employee> loadFromFile(String fileName) {
    List<Employee> list = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader("data.txt", StandardCharsets.UTF_8))) {

      String line = reader.readLine();
      while (line != null) {
        list.add(readEmployee(line));
        line = reader.readLine();
      }
    } catch (IOException e) {
      System.err.println("Can not read data from file " + fileName);
      e.printStackTrace();
    }

    return list;
  }

  private static Employee readEmployee(String line) throws IOException {
    String[] splits = line.split(";");

    if (splits.length < 5)
      throw new IOException("Can not read employee. Not enough elemets in line: " + line);

    String name = splits[0];
    double salary;
    try {
      salary = Double.parseDouble(splits[1]);
    } catch (NumberFormatException e) {
      throw new IOException("Can not read salary in line: " + line, e);
    }

    int year;
    try {
      year = Integer.parseInt(splits[2]);
    } catch (NumberFormatException e) {
      throw new IOException("Can not read year in line: " + line, e);
    }

    int month;
    try {
      month = Integer.parseInt(splits[3]);
    } catch (NumberFormatException e) {
      throw new IOException("Can not read month in line: " + line, e);
    }

    int day;
    try {
      day = Integer.parseInt(splits[4]);
    } catch (NumberFormatException e) {
      throw new IOException("Can not read day in line: " + line, e);
    }

    try {
      return new Employee(name, salary, LocalDate.of(year, month, day));
    } catch (DateTimeException e) {
      throw new IOException("Can not create hire date with line: " + line, e);
    }
  }

}
