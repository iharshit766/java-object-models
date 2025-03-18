import java.util.ArrayList;
import java.util.List;

// School class (Aggregation with Students)
class School {
    private String name;
    private List<Student> students;

    public School(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayStudents() {
        System.out.println("School: " + name);
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            student.displayCourses();
        }
    }
}

// Student class (Association with Courses)
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
            course.addStudent(this);
        }
    }

    public void displayCourses() {
        System.out.println("  Enrolled Courses:");
        for (Course course : courses) {
            System.out.println("    - " + course.getName());
        }
    }
}

// Course class (Association with Students)
class Course {
    private String name;
    private List<Student> students;

    public Course(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
        }
    }

    public void displayStudents() {
        System.out.println("Course: " + name);
        for (Student student : students) {
            System.out.println("  Student: " + student.getName());
        }
    }
}

// SchoolDemo class to demonstrate association and aggregation
public class SchoolDemo {
    public static void main(String[] args) {
        // Creating a school
        School school = new School("Greenwood High");

        // Creating students
        Student student1 = new Student("Alice");
        Student student2 = new Student("Bob");

        // Adding students to school
        school.addStudent(student1);
        school.addStudent(student2);

        // Creating courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses
        student1.enrollInCourse(math);
        student1.enrollInCourse(science);
        student2.enrollInCourse(math);

        // Displaying school structure
        school.displayStudents();

        // Displaying course enrollments
        System.out.println("\nCourse Enrollments:");
        math.displayStudents();
        science.displayStudents();
    }
}
