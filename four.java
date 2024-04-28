// /////part one

// import java.sql.*;

// public class four {
//     // JDBC URL, username, and password of MySQL server
//     private static final String JDBC_URL = "jdbc:mysql://localhost:3306/lab";
//     private static final String USERNAME = "root";
//     private static final String PASSWORD = "password";

//     public static void main(String[] args) {
//         try {
//             // Establishing connection to the database
//             Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

//             // Insert operation
//             String insertQuery = "INSERT INTO users (name, age) VALUES (?, ?)";
//             PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
//             insertStatement.setString(1, "John");
//             insertStatement.setInt(2, 30);
//             insertStatement.executeUpdate();

//             // Update operation
//             String updateQuery = "UPDATE users SET age = ? WHERE name = ?";
//             PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
//             updateStatement.setInt(1, 35);
//             updateStatement.setString(2, "John");
//             updateStatement.executeUpdate();

//             // Delete operation
//             String deleteQuery = "DELETE FROM users WHERE name = ?";
//             PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
//             deleteStatement.setString(1, "John");
//             deleteStatement.executeUpdate();

//             // Select operation
//             String selectQuery = "SELECT * FROM users";
//             Statement selectStatement = connection.createStatement();
//             ResultSet resultSet = selectStatement.executeQuery(selectQuery);
//             while (resultSet.next()) {
//                 String name = resultSet.getString("name");
//                 int age = resultSet.getInt("age");
//                 System.out.println("Name: " + name + ", Age: " + age);
//             }

//             // Closing resources
//             resultSet.close();
//             selectStatement.close();
//             connection.close();
//         } catch (SQLException e) {
//             e.printStackTrace();
//         }
//     }
// }



//////part 2


import java.util.Scanner;

public class four {
    // Main class containing functionality - INQUIRY, TAKE-ON-RENT, ESTIMATE/CHECK FARE, and FEEDBACK
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // INQUIRY for availability of SUV and SEDAN type
        System.out.println("INQUIRY: Available Vehicles - SUV and SEDAN");

        // TAKE-ON-RENT
        System.out.println("TAKE-ON-RENT: Do you want a vehicle with driver or without driver? (Enter 'with' or 'without')");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("with")) {
            WithDriverRental withDriverRental = new WithDriverRental();
            withDriverRental.takeInformation();
        } else if (choice.equalsIgnoreCase("without")) {
            WithoutDriverRental withoutDriverRental = new WithoutDriverRental();
            withoutDriverRental.takeInformation();
        } else {
            System.out.println("Invalid choice.");
        }

        // ESTIMATE/CHECK FARE
        System.out.println("ESTIMATE/CHECK FARE: Fare estimation feature");

        // FEEDBACK
        System.out.println("FEEDBACK: Provide feedback based on unique class identity.");
    }
}

// Class for taking information for vehicle with driver
class WithDriverRental {
    public void takeInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pickup location:");
        String pickupLocation = scanner.nextLine();
        System.out.println("Enter drop location:");
        String dropLocation = scanner.nextLine();
        System.out.println("Enter number of passengers:");
        int numberOfPassengers = scanner.nextInt();
        System.out.println("Information for vehicle with driver:");
        // Additional logic for taking vehicle information with driver
    }
}

// Class for taking information for vehicle without driver
class WithoutDriverRental {
    public void takeInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter pickup location:");
        String pickupLocation = scanner.nextLine();
        System.out.println("Enter drop location:");
        String dropLocation = scanner.nextLine();
        System.out.println("Enter number of passengers:");
        int numberOfPassengers = scanner.nextInt();
        System.out.println("Information for vehicle without driver:");
        // Additional logic for taking vehicle information without driver
    }
}
