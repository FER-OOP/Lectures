package hr.fer.oop.recapitulation.salary;

public class Main {

    public static void main(String[] args) {
        BankManager bankManager = new BankManager();

        SalaryCalculator employeeList[] = new SalaryCalculator[3];

        Salesman salesman = new Salesman("s1", "s1b", 3000);
        salesman.setTurnover(10000);
        employeeList[0] = salesman;

        HourBasedWorker hourWorker1 = new HourBasedWorker("h1_no", "h1", 50);
        hourWorker1.setWorkingHours(100);
        employeeList[1] = hourWorker1;

        HourBasedWorker hourWorker2 = new HourBasedWorker("h2_overtime", "h2", 50);
        hourWorker2.setWorkingHours(200);
        employeeList[2] = hourWorker2;

        for (SalaryCalculator salaryCalculator : employeeList) {
            salaryCalculator.paySalary(bankManager);
        }
    }
}
