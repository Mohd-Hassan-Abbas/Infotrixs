package infotrixs.hassan.system1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    private String dataFile;
    private List<Employee> employees;

    public DataAccess(String dataFile) {
        this.dataFile = dataFile;
        this.employees = loadEmployees();
    }

    private List<Employee> loadEmployees() {
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String id = parts[0];
                    String name = parts[1];
                    String designation = parts[2];
                    Employee employee = new Employee(id, name, designation);
                    employees.add(employee);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading employee data: " + e.getMessage());
        }

        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        saveEmployees();
    }

    public void updateEmployee(Employee updatedEmployee) {
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getId().equals(updatedEmployee.getId())) {
                employees.set(i, updatedEmployee);
                saveEmployees();
                return;
            }
        }
    }

    public Employee getEmployeeById(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                return employee;
            }
        }
        return null;
    }

    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
                System.out.println("--------------------");
            }
        }
    }

    private void saveEmployees() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getDesignation());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

    public void close() {
        saveEmployees();
    }
}