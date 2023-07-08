package infotrixs.hassan.system1;

import java.util.Scanner;

public class Management {
    private static final String DATA_FILE = "employees.txt";
    private static DataAccess dataAccess;
    private static Scanner scanner;

    public static void main(String[] args) {
        dataAccess = new DataAccess(DATA_FILE);
        scanner = new Scanner(System.in);

        int choice;
        do {
            printMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    System.out.println("Exiting the Employee Management System...");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        } while (choice != 5);

        dataAccess.close();
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("========== Employee Management System ==========");
        System.out.println("1. Add Employee");
        System.out.println("2. View Employees");
        System.out.println("3. Update Employee");
        System.out.println("4. Search Employee");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void addEmployee() {
        System.out.println("========== Add Employee ==========");
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter employee designation: ");
        String designation = scanner.nextLine();

        Employee newEmployee = new Employee(id, name, designation);
        dataAccess.addEmployee(newEmployee);
        System.out.println("Employee added successfully!");
    }

    private static void viewEmployees() {
        System.out.println("========== View Employees ==========");
        dataAccess.viewEmployees();
    }

    private static void updateEmployee() {
        System.out.println("========== Update Employee ==========");
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();

        Employee employee = dataAccess.getEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with ID " + id + " does not exist.");
            return;
        }

        System.out.println("Current Employee Details:");
        System.out.println(employee);

        System.out.print("Enter new employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new employee designation: ");
        String designation = scanner.nextLine();

        Employee updatedEmployee = new Employee(id, name, designation);
        dataAccess.updateEmployee(updatedEmployee);
        System.out.println("Employee updated successfully!");
    }

    private static void searchEmployee() {
        System.out.println("========== Search Employee ==========");
        System.out.print("Enter employee ID: ");
        String id = scanner.nextLine();

        Employee employee = dataAccess.getEmployeeById(id);
        if (employee == null) {
            System.out.println("Employee with ID " + id + " does not exist.");
        } else {
            System.out.println("Employee Details:");
            System.out.println(employee);
        }
    }
}