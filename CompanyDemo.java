import java.util.ArrayList;
import java.util.List;

// Company class
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addEmployeeToDepartment(String departmentName, String employeeName) {
        for (Department department : departments) {
            if (department.getName().equals(departmentName)) {
                department.addEmployee(employeeName);
                return;
            }
        }
        System.out.println("Department not found: " + departmentName);
    }

    public void displayCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department department : departments) {
            department.displayEmployees();
        }
    }
}

// Department class (Composition)
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }

    public void displayEmployees() {
        System.out.println("Department: " + name);
        for (Employee employee : employees) {
            System.out.println("  Employee: " + employee.getName());
        }
    }
}

// Employee class (Exists only within a Department)
class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// CompanyDemo class to demonstrate composition
public class CompanyDemo {
    public static void main(String[] args) {
        // Creating a company
        Company company = new Company("TechCorp");

        // Adding departments
        company.addDepartment("IT");
        company.addDepartment("HR");

        // Adding employees to departments
        company.addEmployeeToDepartment("IT", "Alice");
        company.addEmployeeToDepartment("IT", "Bob");
        company.addEmployeeToDepartment("HR", "Charlie");

        // Displaying company structure
        company.displayCompanyStructure();
    }
}

