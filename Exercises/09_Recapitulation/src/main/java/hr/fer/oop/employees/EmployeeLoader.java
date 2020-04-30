package hr.fer.oop.employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class EmployeeLoader {
  public static List<Employee> loadFromFile(String fileName) {
    List<Employee> staff = new ArrayList<>();

    try (BufferedReader br = new BufferedReader(new FileReader(fileName, StandardCharsets.UTF_8))) {
        String strLine;
        while ((strLine = br.readLine()) != null) {
            String[] inputData = strLine.split(";");
            staff.add(new Employee(inputData[0], Double.parseDouble(inputData[1]), Integer.parseInt(inputData[2]), Integer.parseInt(inputData[3]), Integer.parseInt(inputData[4])));
        }
    } catch (IOException e) {
      System.err.println("Can not load data from " + fileName);
      e.printStackTrace();
    }

    return staff;
  }
}
