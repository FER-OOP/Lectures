package hr.fer.oop.recapitulation.salary;

public class HourBasedWorker extends Worker {

    private static final double MONTHLY_WORKING_HOURS = 160;
    private static final double OVERTIME_FACTOR = 1.2;
    private double workingHours;
    private double salaryPerHour;

    public HourBasedWorker(String name, String bankNumber, double salaryPerHour) {
        super(name, bankNumber);
        if (salaryPerHour <= 0) {
            throw new IllegalArgumentException();
        }
        this.salaryPerHour = salaryPerHour;
    }

    @Override
    public void paySalary(BankManager bankManager) {
        if (workingHours < MONTHLY_WORKING_HOURS) {
            bankManager.payment(this, workingHours * salaryPerHour);
        } else {
            bankManager.payment(this, ((workingHours - MONTHLY_WORKING_HOURS) * OVERTIME_FACTOR + MONTHLY_WORKING_HOURS) * salaryPerHour);
        }
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }
}
