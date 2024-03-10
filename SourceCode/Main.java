package SourceCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t-------------------Admin Panel Payroll System-------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");

        while (true) {
            System.out.println("\nChoose the type of employee to add:");
            System.out.println("1. Full-time Employee");
            System.out.println("2. Part-time Employee");
            System.out.println("3. Contractor Employee");
            System.out.println("4. Intern Employee");
            System.out.println("5. Display Employees");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter Full-time Employee details:");
                    System.out.print("Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    System.out.print("Monthly Salary: ");
                    double monthlySalary = scanner.nextDouble();
                    payrollSystem.addEmployee(new FullTimeEmployee(fullName, id, monthlySalary));
                    break;
                case 2:
                    System.out.println("Enter Part-time Employee details:");
                    System.out.print("Name: ");
                    String partTimeName = scanner.nextLine();
                    System.out.print("ID: ");
                    int partTimeId = scanner.nextInt();
                    System.out.print("Hours Worked: ");
                    int hoursWorked = scanner.nextInt();
                    System.out.print("Hourly Rate: ");
                    double hourlyRate = scanner.nextDouble();
                    payrollSystem.addEmployee(new PartTimeEmployee(partTimeName, partTimeId, hoursWorked, hourlyRate));
                    break;
                case 3:
                    System.out.println("Enter Contractor Employee details:");
                    System.out.print("Name: ");
                    String contractorName = scanner.nextLine();
                    System.out.print("ID: ");
                    int contractorId = scanner.nextInt();
                    System.out.print("Contract Duration (in months): ");
                    int contractDuration = scanner.nextInt();
                    System.out.print("Hourly Rate: ");
                    double contractorHourlyRate = scanner.nextDouble();
                    payrollSystem.addEmployee(new ContractorEmployee(contractorName, contractorId, contractDuration, contractorHourlyRate));
                    break;
                case 4:
                    System.out.println("Enter Intern Employee details:");
                    System.out.print("Name: ");
                    String internName = scanner.nextLine();
                    System.out.print("ID: ");
                    int internId = scanner.nextInt();
                    System.out.print("Duration (in months): ");
                    int durationInMonths = scanner.nextInt();
                    System.out.print("Monthly Stipend: ");
                    double monthlyStipend = scanner.nextDouble();
                    payrollSystem.addEmployee(new InternEmployee(internName, internId, durationInMonths, monthlyStipend));
                    break;
                case 5:
                    System.out.println("\n\nEmployee Details:");
                    displayEmployeeDetails(payrollSystem);
                    break;
                case 6:
                    System.out.println("Thanks For Visiting\nHappy coding...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    // Method to display employee details in row and column-wise format
    private static void displayEmployeeDetails(PayrollSystem payrollSystem) {
        System.out.println("Name\t\tID\t\tSalary\t\tDuration (Months)");
        for (Employee employee : payrollSystem.getEmployeeList()) {
            if (employee instanceof InternEmployee) {
                InternEmployee intern = (InternEmployee) employee;
                System.out.println(intern.getName() + "\t\t" + intern.getId() + "\t\t" + intern.calculateSalary() + "\t\t" + intern.getDurationInMonths());
            } else {
                System.out.println(employee.getName() + "\t\t" + employee.getId() + "\t\t" + employee.calculateSalary() + "\t\t-");
            }
        }
    }
}

