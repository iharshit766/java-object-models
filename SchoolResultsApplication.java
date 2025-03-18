
import java.util.ArrayList;
import java.util.List;

// Class representing a Subject with name and marks
class Subject {
    private String name;
    private int marks;

    public Subject(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}

// Class representing a Student with a list of subjects
class Student {
    private String name;
    private List<Subject> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new ArrayList<>();
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public String getName() {
        return name;
    }
}

// Class responsible for calculating grades based on marks
class GradeCalculator {
    public static String calculateGrade(Student student) {
        int totalMarks = 0;
        int subjectCount = student.getSubjects().size();

        if (subjectCount == 0) {
            return "No subjects available for grading.";
        }

        for (Subject subject : student.getSubjects()) {
            totalMarks += subject.getMarks();
        }

        double average = (double) totalMarks / subjectCount;

        // Assigning grades based on average marks
        if (average >= 90) return "A+";
        else if (average >= 80) return "A";
        else if (average >= 70) return "B";
        else if (average >= 60) return "C";
        else if (average >= 50) return "D";
        else return "F";
    }
}

// Main class to demonstrate the working of the application
public class SchoolResultsApplication {
    public static void main(String[] args) {
        // Creating a student
        Student student = new Student("John");

        // Adding subjects with marks
        student.addSubject(new Subject("Maths", 90));
        student.addSubject(new Subject("Science", 85));

        // Calculating grade
        String grade = GradeCalculator.calculateGrade(student);

        // Displaying results
        System.out.println("Student: " + student.getName());
        System.out.println("Subjects & Marks:");
        for (Subject subject : student.getSubjects()) {
            System.out.println(subject.getName() + ": " + subject.getMarks());
        }
        System.out.println("Final Grade: " + grade);
    }
}
