import java.util.ArrayList;
import java.util.List;

// University class (Composition with Departments, Aggregation with Faculty)
class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> facultyMembers;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void displayUniversityStructure() {
        System.out.println("University: " + name);
        System.out.println("Departments:");
        for (Department department : departments) {
            department.displayDepartment();
        }
        System.out.println("\nFaculty Members:");
        for (Faculty faculty : facultyMembers) {
            System.out.println("  " + faculty.getName());
        }
    }
}

// Department class (Composition with University)
class Department {
    private String name;
    private List<Faculty> faculty;

    public Department(String name) {
        this.name = name;
        this.faculty = new ArrayList<>();
    }

    public void addFaculty(Faculty facultyMember) {
        faculty.add(facultyMember);
    }

    public void displayDepartment() {
        System.out.println("  Department: " + name);
        for (Faculty facultyMember : faculty) {
            System.out.println("    Faculty: " + facultyMember.getName());
        }
    }
}

// Faculty class (Exists independently of a Department)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// UniversityDemo class to demonstrate composition and aggregation
public class UniversityDemo {
    public static void main(String[] args) {
        // Creating a university
        University university = new University("Tech University");

        // Adding departments
        university.addDepartment("Computer Science");
        university.addDepartment("Physics");

        // Creating faculty members
        Faculty profAlice = new Faculty("Professor Alice");
        Faculty profBob = new Faculty("Professor Bob");
        Faculty profCharlie = new Faculty("Professor Charlie");

        // Adding faculty to the university
        university.addFaculty(profAlice);
        university.addFaculty(profBob);
        university.addFaculty(profCharlie);

        // Displaying university structure
        university.displayUniversityStructure();
    }
}
