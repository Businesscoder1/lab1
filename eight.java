// ////P1

// // AbstractDemo.java

// abstract class AbstractClass {
//     // Abstract method
//     public abstract void display();

//     // Normal method
//     public void show() {
//         System.out.println("This is a normal method in abstract class.");
//     }

//     // Illegal combination of modifiers
//     // private abstract void illegalMethod(); // Error: illegal combination of modifiers
// }

// // Illegal combination of modifiers
// // final abstract class IllegalClass {} // Error: illegal combination of modifiers

// public class eight {
//     public static void main(String[] args) {
//         // AbstractClass obj = new AbstractClass(); // Error: cannot instantiate abstract class
//         ConcreteClass obj = new ConcreteClass(); // Creating object of ConcreteClass
//         obj.display(); // Calling abstract method
//         obj.show(); // Calling normal method
//     }
// }

// class ConcreteClass extends AbstractClass {
//     @Override
//     public void display() {
//         System.out.println("Abstract method implementation in ConcreteClass.");
//     }
// }

////////P2

// LoginApplication.java

import java.util.Scanner;

class User {
    private String username;
    private String password;
    private String userInfo;

    public User(String username, String password, String userInfo) {
        this.username = username;
        this.password = password;
        this.userInfo = userInfo;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getUserInfo() {
        return userInfo;
    }
}

public class eight {
    public static void main(String[] args) {
        // Create user
        User user = new User("user123", "password123", "Name: John Doe\nAge: 30\nEmail: john@example.com");

        // Take input from user
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        // Authenticate user
        if (user.authenticate(username, password)) {
            System.out.println("Login successful!");
            System.out.println("User Information:\n" + user.getUserInfo());
        } else {
            System.out.println("Wrong username or password.");
        }

        // Close scanner
        scanner.close();
    }
}

