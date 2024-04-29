//part one
// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;

// public class twelve {
//     public static void main(String[] args) {
//         try {
//             // Specify the path to the file
//             File file = new File("example.txt");

//             // Get the size of the file in bytes
//             long fileSize = file.length();
//             System.out.println("File Size: " + fileSize + " bytes");

//             // Open the FileInputStream
//             FileInputStream inputStream = new FileInputStream(file);

//             // Skip a certain number of bytes
//             long bytesToSkip = 10; // Example: Skip 10 bytes
//             inputStream.skip(bytesToSkip);
//             System.out.println("Skipped " + bytesToSkip + " bytes");

//             // Check how many times the stream can be read (using mark and reset methods)
//             if (inputStream.markSupported()) {
//                 inputStream.mark((int) fileSize); // Mark the current position in the stream
//                 int count = 0;
//                 while (inputStream.read() != -1) {
//                     count++;
//                 }
//                 System.out.println("Stream can be read " + count + " times");
//                 inputStream.reset(); // Reset the stream to the marked position
//             } else {
//                 System.out.println("mark/reset not supported");
//             }

//             // Close the FileInputStream
//             inputStream.close();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }


//part two
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

class Student {
    private String name;
    private String rollNumber;

    public Student(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public String getRollNumber() {
        return rollNumber;
    }
}

public class twelve {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Student> cseStudents = new LinkedHashSet<>(); // Using LinkedHashSet to maintain order and avoid duplicates

        while (true) {
            System.out.println("Enter student name:");
            String name = scanner.nextLine();
            System.out.println("Enter student roll number:");
            String rollNumber = scanner.nextLine();

            Student student = new Student(name, rollNumber);
            if (!cseStudents.contains(student)) {
                cseStudents.add(student);
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Duplicate entry. Student already exists.");
            }

            System.out.println("Do you want to add another student? (yes/no)");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                break;
            }
        }

        // Display CSE students
        System.out.println("CSE Students:");
        for (Student student : cseStudents) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber());
        }

        // Create sub collections for SY, TY, and BTECH students
        Set<Student> syStudents = new LinkedHashSet<>();
        Set<Student> tyStudents = new LinkedHashSet<>();
        Set<Student> btechStudents = new LinkedHashSet<>();
        for (Student student : cseStudents) {
            if (student.getRollNumber().startsWith("SY")) {
                syStudents.add(student);
            } else if (student.getRollNumber().startsWith("TY")) {
                tyStudents.add(student);
            } else if (student.getRollNumber().startsWith("BTECH")) {
                btechStudents.add(student);
            }
        }

        // Display SY students
        System.out.println("SY Students:");
        for (Student student : syStudents) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber());
        }

        // Display TY students
        System.out.println("TY Students:");
        for (Student student : tyStudents) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber());
        }

        // Display BTECH students
        System.out.println("BTECH Students:");
        for (Student student : btechStudents) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber());
        }

        scanner.close();
    }
}

