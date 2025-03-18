import java.util.ArrayList;
import java.util.List;

// University class containing students and professors
class University {
    private String name;
    private List<Student> students;
    private List<Professor> professors;
    private List<Course> courses;

    public University(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.professors = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void displayUniversityInfo() {
        System.out.println("University: " + name);
        System.out.println("Students:");
        for (Student student : students) {
            System.out.println("  " + student.getName());
        }
        System.out.println("\nProfessors:");
        for (Professor professor : professors) {
            System.out.println("  " + professor.getName());
        }
        System.out.println("\nCourses:");
        for (Course course : courses) {
            System.out.println("  " + course.getCourseName());
        }
    }
}

// Student class (enrolls in multiple courses)
class Student {
    private String name;
    private List<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this);
    }
}

// Professor class (teaches multiple courses)
class Professor {
    private String name;
    private List<Course> assignedCourses;

    public Professor(String name) {
        this.name = name;
        this.assignedCourses = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
        course.setProfessor(this);
    }
}

// Course class
class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void displayCourseInfo() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Enrolled Students:");
        for (Student student : students) {
            System.out.println("  " + student.getName());
        }
    }
}

// UniversityDemo class to demonstrate the system
public class UniversityDemo2 {
    public static void main(String[] args) {
        // Creating a university
        University university = new University("Tech University");

        // Creating students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");
        university.addStudent(alice);
        university.addStudent(bob);

        // Creating professors
        Professor drSmith = new Professor("Dr. Smith");
        Professor drJones = new Professor("Dr. Jones");
        university.addProfessor(drSmith);
        university.addProfessor(drJones);

        // Creating courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");
        university.addCourse(math);
        university.addCourse(cs);

        // Assigning professors to courses
        drSmith.assignCourse(math);
        drJones.assignCourse(cs);

        // Enrolling students in courses
        alice.enrollCourse(math);
        bob.enrollCourse(cs);
        alice.enrollCourse(cs);

        // Displaying course details
        math.displayCourseInfo();
        cs.displayCourseInfo();

        // Displaying university info
        university.displayUniversityInfo();
    }
}
