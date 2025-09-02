package LabProblems;
class Employee {
    private String empId, name, dept, type;
    private double baseSalary;
    private static int totalEmployees = 0;

    public Employee(String n, String d, double sal, String t) {
        totalEmployees++;
        this.empId = "E" + totalEmployees;
        this.name = n; this.dept = d; this.baseSalary = sal; this.type = t;
    }

    public double calculateSalary(double bonus) { return baseSalary + bonus; }          // Full-time
    public double calculateSalary(int hrs, double rate) { return hrs * rate; }          // Part-time
    public double calculateSalary(double contractAmt) { return contractAmt; }           // Contract

    public void display() {
        System.out.println(empId + " | " + name + " | " + dept + " | " + type);
    }
}

public class PayrollSystem {
    public static void main(String[] args) {
        Employee e1 = new Employee("Alice", "IT", 30000, "Full-time");
        Employee e2 = new Employee("Bob", "HR", 0, "Part-time");

        e1.display();
        System.out.println("Salary: " + e1.calculateSalary(5000));
        e2.display();
        System.out.println("Salary: " + e2.calculateSalary(20, 200));
    }
}

