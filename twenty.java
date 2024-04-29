//part one

// import java.util.*;

// class Student implements Comparable<Student> {
//     private int rollNumber;
//     private String name;
//     private String branch;
//     private double gradePointer;

//     public Student(int rollNumber, String name, String branch, double gradePointer) {
//         this.rollNumber = rollNumber;
//         this.name = name;
//         this.branch = branch;
//         this.gradePointer = gradePointer;
//     }

//     // Getters and setters

//     @Override
//     public String toString() {
//         return "Student{" +
//                 "rollNumber=" + rollNumber +
//                 ", name='" + name + '\'' +
//                 ", branch='" + branch + '\'' +
//                 ", gradePointer=" + gradePointer +
//                 '}';
//     }

//     @Override
//     public int compareTo(Student other) {
//         // Compare students based on roll number
//         return Integer.compare(this.rollNumber, other.rollNumber);
//     }

//     public static Comparator<Student> GradeComparator = new Comparator<Student>() {
//         @Override
//         public int compare(Student s1, Student s2) {
//             // Compare students based on grade pointer
//             return Double.compare(s1.gradePointer, s2.gradePointer);
//         }
//     };
// }

// public class twenty {
//     private List<Student> students;

//     public StudentDatabase() {
//         students = new ArrayList<>();
//     }

//     public void addStudent(Student student) {
//         students.add(student);
//     }

//     public void sortStudents(Comparator<Student> comparator) {
//         Collections.sort(students, comparator);
//     }

//     public Student searchStudent(int rollNumber) {
//         for (Student student : students) {
//             if (student.getRollNumber() == rollNumber) {
//                 return student;
//             }
//         }
//         return null; // Student not found
//     }

//     public List<Student> getStudentsByBranch(String branch) {
//         List<Student> branchStudents = new ArrayList<>();
//         for (Student student : students) {
//             if (student.getBranch().equalsIgnoreCase(branch)) {
//                 branchStudents.add(student);
//             }
//         }
//         return branchStudents;
//     }

//     public int countStudentsByGrade(double grade) {
//         int count = 0;
//         for (Student student : students) {
//             if (student.getGradePointer() == grade) {
//                 count++;
//             }
//         }
//         return count;
//     }

//     public static void main(String[] args) {
//         StudentDatabase database = new StudentDatabase();

//         // Adding sample students
//         database.addStudent(new Student(101, "John", "CSE", 8.5));
//         database.addStudent(new Student(102, "Alice", "ECE", 8.2));
//         database.addStudent(new Student(103, "Bob", "CSE", 9.0));
//         database.addStudent(new Student(104, "David", "Mech", 7.8));

//         // Sorting students based on roll number
//         database.sortStudents(null);
//         System.out.println("Students sorted by roll number:");
//         System.out.println(database.students);

//         // Searching for a student
//         int rollNumberToSearch = 102;
//         Student searchedStudent = database.searchStudent(rollNumberToSearch);
//         System.out.println("Searched Student: " + searchedStudent);

//         // Creating sub-database for a branch
//         String branch = "CSE";
//         List<Student> cseStudents = database.getStudentsByBranch(branch);
//         System.out.println("CSE Students:");
//         System.out.println(cseStudents);

//         // Counting students with a specific grade
//         double gradeToCount = 8.5;
//         int count = database.countStudentsByGrade(gradeToCount);
//         System.out.println("Number of students with grade " + gradeToCount + ": " + count);
//     }
// }

//part two
public class twenty {
    public static void main(String[] args) {
        // Getting reference to the current thread
        Thread currentThread = Thread.currentThread();

        // Displaying thread information
        System.out.println("Thread Name: " + currentThread.getName());
        System.out.println("Thread ID: " + currentThread.getId());
        System.out.println("Thread Priority: " + currentThread.getPriority());
        System.out.println("Thread State: " + currentThread.getState());
        System.out.println("Thread Group: " + currentThread.getThreadGroup().getName());
        System.out.println("Is Thread Daemon: " + currentThread.isDaemon());
        System.out.println("Is Thread Alive: " + currentThread.isAlive());
    }
}


