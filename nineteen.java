//part one

// import java.io.*;

// class Car implements Serializable {
//     private static int totalCars = 0; // Static data member
//     private transient String owner;   // Transient data member
//     private String brand;
//     private int year;

//     public Car(String owner, String brand, int year) {
//         this.owner = owner;
//         this.brand = brand;
//         this.year = year;
//         totalCars++;
//     }

//     public static int getTotalCars() {
//         return totalCars;
//     }

//     @Override
//     public String toString() {
//         return "Car{owner='" + owner + "', brand='" + brand + "', year=" + year + '}';
//     }
// }

// public class nineteen {
//     private static final String FILE_PATH = "cars.ser";

//     public static void main(String[] args) {
//         // Serialize objects into file
//         try {
//             serializeCars(new Car("John", "Toyota", 2020), new Car("Alice", "Honda", 2018));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         // Deserialize objects from file
//         try {
//             deserializeCars();
//         } catch (IOException | ClassNotFoundException e) {
//             e.printStackTrace();
//         }
//     }

//     // Method to serialize cars into a file
//     private static void serializeCars(Car... cars) throws IOException {
//         try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
//             for (Car car : cars) {
//                 outputStream.writeObject(car);
//             }
//             System.out.println("Cars serialized successfully.");
//         }
//     }

//     // Method to deserialize cars from a file
//     private static void deserializeCars() throws IOException, ClassNotFoundException {
//         try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
//             System.out.println("Deserialized Cars:");
//             while (true) {
//                 Car car = (Car) inputStream.readObject();
//                 System.out.println(car);
//             }
//         } catch (EOFException e) {
//             // Reached end of file
//         }
//     }
// }

//part two
import java.sql.*;

class Student {
    private String name;
    private int rollNumber;
    private int age;

    // Constructor, getters, setters

    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNumber=" + rollNumber + ", age=" + age + '}';
    }
}

public class nineteen {
    private static final String URL = "jdbc:mysql://localhost:3306/student_db";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Insert new student
        Student student1 = new Student("John", 101, 20);
        insertStudent(student1);

        // Retrieve student information by roll number
        int rollNumber = 101;
        Student retrievedStudent = getStudentByRollNumber(rollNumber);
        System.out.println("Student information for roll number " + rollNumber + ": " + retrievedStudent);
    }

    // Method to insert a student into the database
    private static void insertStudent(Student student) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO students VALUES (?, ?, ?)")) {
            statement.setString(1, student.getName());
            statement.setInt(2, student.getRollNumber());
            statement.setInt(3, student.getAge());
            statement.executeUpdate();
            System.out.println("Student inserted into database successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to retrieve student information by roll number
    private static Student getStudentByRollNumber(int rollNumber) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE roll_number = ?")) {
            statement.setInt(1, rollNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                return new Student(name, rollNumber, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
