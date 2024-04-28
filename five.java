import java.util.*;

// Student class representing student information
class Student implements Comparable<Student> {
    private String name;
    private int jeeMark;
    private int twelfthMark;
    private int tenthMark;

    // Constructor
    public Student(String name, int jeeMark, int twelfthMark, int tenthMark) {
        this.name = name;
        this.jeeMark = jeeMark;
        this.twelfthMark = twelfthMark;
        this.tenthMark = tenthMark;
    }

    // Getter methods
    public String getName() {
        return name;
    }

    public int getJeeMark() {
        return jeeMark;
    }

    public int getTwelfthMark() {
        return twelfthMark;
    }

    public int getTenthMark() {
        return tenthMark;
    }

    // Implementing compareTo method for sorting
    @Override
    public int compareTo(Student other) {
        // Sorting based on JEE marks, then 12th marks, then 10th marks
        if (this.jeeMark != other.jeeMark) {
            return other.jeeMark - this.jeeMark; // Descending order of JEE marks
        } else if (this.twelfthMark != other.twelfthMark) {
            return other.twelfthMark - this.twelfthMark; // Descending order of 12th marks
        } else {
            return other.tenthMark - this.tenthMark; // Descending order of 10th marks
        }
    }

    // Override toString() method for better representation
    @Override
    public String toString() {
        return "Name: " + name + ", JEE Mark: " + jeeMark + ", 12th Mark: " + twelfthMark + ", 10th Mark: " + tenthMark;
    }
}

public class five {
    public static void main(String[] args) {
        // Create a list to store student records
        List<Student> studentList = new ArrayList<>();

        // Add sample student records
        studentList.add(new Student("Alice", 90, 95, 98));
        studentList.add(new Student("Bob", 95, 92, 97));
        studentList.add(new Student("Charlie", 85, 96, 93));

        // Sort the student list using natural ordering (Comparable interface)
        Collections.sort(studentList);

        // Display the sorted student list
        System.out.println("Sorted Student Records:");
        for (Student student : studentList) {
            System.out.println(student);
        }
    }
}

