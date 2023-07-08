package infotrixs.hassan.system1;

public class Employee {
    private String id;
    private String name;
    private String designation;

    public Employee(String id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    @Override
    public String toString() {
        return "Employee ID: " + id +
                "\nName: " + name +
                "\nDesignation: " + designation;
    }
}