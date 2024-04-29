// import java.util.Scanner;

// public class eleven {
//     private String name;
//     private int[] marks = new int[5];

//     public eleven(boolean getInfo) {
//         if (getInfo) {
//             // Anonymous class to display information about Student class
//             new Object() {
//                 {
//                     System.out.println("Student class contains methods to interact with student information:");
//                     System.out.println("1. getdata() - to input student information");
//                     System.out.println("2. display() - to display student information");
//                     System.out.println("3. estimate() - to calculate student percentage based on 5 subject marks");
//                 }
//             };
//         }
//     }

//     public void getData() {
//         Scanner scanner = new Scanner(System.in);
//         System.out.println("Enter student name:");
//         name = scanner.nextLine();
//         System.out.println("Enter marks for 5 subjects:");
//         for (int i = 0; i < 5; i++) {
//             marks[i] = scanner.nextInt();
//         }
//     }

//     public void display() {
//         System.out.println("Student Name: " + name);
//         System.out.println("Subject Marks:");
//         for (int i = 0; i < 5; i++) {
//             System.out.println("Subject " + (i + 1) + ": " + marks[i]);
//         }
//     }

//     public void estimate() {
//         int totalMarks = 0;
//         for (int mark : marks) {
//             totalMarks += mark;
//         }
//         double percentage = (double) totalMarks / 5;
//         System.out.println("Student Percentage: " + percentage);
//     }

//     public static void main(String[] args) {
//         eleven student = new eleven(true);
//         student.getData();
//         student.display();
//         student.estimate();
//     }
// }


//////////p2

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class eleven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text to write into the file:");
        String text = scanner.nextLine();
        scanner.close();

        try {
            FileWriter writer = new FileWriter("output.txt");
            writer.write(text);
            writer.close();
            System.out.println("Text written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
