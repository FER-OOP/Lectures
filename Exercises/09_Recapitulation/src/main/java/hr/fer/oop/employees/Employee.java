package hr.fer.oop.employees;

import java.time.LocalDate;

public class Employee {
  private String name;
  private double salary;
  private LocalDate hireDate;

  public Employee(String name, double salary, LocalDate hireDate) {
    this.name = name;
    this.salary = salary;
    this.hireDate = hireDate;
  }

  public String getName() {
    return name;
  }

  public double getSalary() {
    return salary;
  }

  public LocalDate getHireDate() {
    return hireDate;
  }

  public void raiseSalary(double byPercent) {
    salary *= byPercent / 100.0 + 1.0;
  }

  @Override
  public String toString() {
    return "Employee [name=" + name + ", salary=" + salary + ", hireDate=" + hireDate + "]";
  }
}
