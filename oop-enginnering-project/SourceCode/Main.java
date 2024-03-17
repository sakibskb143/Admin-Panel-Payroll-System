package SourceCode;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PayrollSystem payrollSystem = new PayrollSystem();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\n------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t-------------------Admin Panel Employee Payroll System-------------------");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");

        while (true) {
            System.out.println("\nChoose the type of operation:");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Code to add employee
                    addEmployee(payrollSystem, scanner);
                    break;
                case 2:
                    // Code to remove employee
                    removeEmployee(payrollSystem, scanner);
                    break;
                case 3:
                    displayEmployeeDetails(payrollSystem);
                    break;
                case 4:
                    System.out.println("Successfully Logout Completed!!.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }

    private static void addEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.println("\n\t\tChoose the type of employee to add:");
        System.out.println("\t\t1. Full-time Employee");
        System.out.println("\t\t2. Part-time Employee");
        System.out.println("\t\t3. Contractor Employee");
        System.out.println("\t\t4. Intern Employee");

        System.out.print("\t\tEnter Add Option:");
        int choice = scanner.nextInt();
       
        scanner.nextLine(); // Consume newline
    
        switch (choice) {
            case 1:
                // Code to add full-time employee
                // Prompt user for details
                System.out.println("\n\t\tEnter Full-time Employee details:");
                System.out.print("\t\tName: ");
                String fullName = scanner.nextLine();
                System.out.print("\t\tID: ");
                int id = scanner.nextInt();
                System.out.print("\t\tMonthly Salary: ");
                double monthlySalary = scanner.nextDouble();
                // Add employee
                payrollSystem.addEmployee(new FullTimeEmployee(fullName, id, monthlySalary));
                break;
            case 2:
                // Code to add part-time employee
                // Prompt user for details
                System.out.println("\n\t\tEnter Part-time Employee details:");
                System.out.print("\t\tName: ");
                String partTimeName = scanner.nextLine();
                System.out.print("\t\tID: ");
                int partTimeId = scanner.nextInt();
                System.out.print("\t\tHours Worked: ");
                int hoursWorked = scanner.nextInt();
                System.out.print("\t\tHourly Rate: ");
                double hourlyRate = scanner.nextDouble();
                // Add employee
                payrollSystem.addEmployee(new PartTimeEmployee(partTimeName, partTimeId, hoursWorked, hourlyRate));
                break;
            case 3:
                // Code to add contractor employee
                // Prompt user for details
                System.out.println("\n\t\tEnter Contractor Employee details:");
                System.out.print("\t\tName: ");
                String contractorName = scanner.nextLine();
                System.out.print("\t\tID: ");
                int contractorId = scanner.nextInt();
                System.out.print("\t\tContract Duration (in months): ");
                int contractDuration = scanner.nextInt();
                System.out.print("\t\tHourly Rate: ");
                double contractorHourlyRate = scanner.nextDouble();
                // Add employee
                payrollSystem.addEmployee(new ContractorEmployee(contractorName, contractorId, contractDuration, contractorHourlyRate));
                break;
            case 4:
                // Code to add intern employee
                // Prompt user for details
                System.out.println("\n\t\tEnter Intern Employee details:");
                System.out.print("\t\tName: ");
                String internName = scanner.nextLine();
                System.out.print("\t\tID: ");
                int internId = scanner.nextInt();
                System.out.print("\t\tDuration (in months): ");
                int durationInMonths = scanner.nextInt();
                System.out.print("\t\tMonthly Stipend: ");
                double monthlyStipend = scanner.nextDouble();
                // Add employee
                payrollSystem.addEmployee(new InternEmployee(internName, internId, durationInMonths, monthlyStipend));
                break;
            default:
                System.out.println("\t\tInvalid choice. Please enter a number between 1 and 4.");
        }
    }
    
    private static void removeEmployee(PayrollSystem payrollSystem, Scanner scanner) {
        System.out.println("\nEnter the ID of the employee to remove:");
        int idToRemove = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        payrollSystem.removeEmployee(idToRemove);
       
    }

    // Method to display employee details in row and column-wise format
    private static void displayEmployeeDetails(PayrollSystem payrollSystem) {
        System.out.println("\nName\t\tID\t\tSalary\t\tduration(in Months)");
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
