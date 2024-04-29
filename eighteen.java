import java.io.*;

class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + "}";
    }
}

public class eighteen {
    private static final String FILE_PATH = "student_info.txt";

    public static void main(String[] args) {
        try {
            // Write student object state information to file
            writeStudentToFile(new Student("John", 20));

            // Read student object state information from file
            Student student = readStudentFromFile();
            System.out.println("Student information read from file: " + student);
        } catch (IOException e) {
            // Handle IOException (FileNotFoundException, EOFException, SecurityException)
            e.printStackTrace();
        } catch (NullPointerException e) {
            // Handle NullPointerException
            System.err.println("NullPointerException occurred: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // Handle IllegalArgumentException
            System.err.println("IllegalArgumentException occurred: " + e.getMessage());
        } catch (IllegalStateException e) {
            // Handle IllegalStateException
            System.err.println("IllegalStateException occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFoundException
            System.err.println("ClassNotFoundException occurred: " + e.getMessage());
        }
    }

    // Method to write student object state information to file
    private static void writeStudentToFile(Student student) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            outputStream.writeObject(student);
            System.out.println("Student information written to file successfully.");
        }
    }

    // Method to read student object state information from file
    private static Student readStudentFromFile() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Student) inputStream.readObject();
        }
    }
}
