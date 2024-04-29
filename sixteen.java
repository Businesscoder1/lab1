//part one 
// import java.io.File;
// import java.io.IOException;

// public class sixteen {
//     public static void main(String[] args) {
//         String fileName = "example.txt"; // Example file name

//         // Creating a file
//         createFile(fileName);

//         // Checking if file is present
//         System.out.println("File present: " + isFilePresent(fileName));

//         // Getting file name
//         System.out.println("File name: " + getFileName(fileName));

//         // Getting path name
//         System.out.println("Path name: " + getPathName(fileName));

//         // Checking if it's a file
//         System.out.println("Is it a file: " + isFile(fileName));

//         // Getting file parent
//         System.out.println("File parent: " + getFileParent(fileName));

//         // Checking if modification is allowed
//         System.out.println("Modification allowed: " + isModificationAllowed(fileName));

//         // Checking if execution is allowed
//         System.out.println("Execution allowed: " + isExecutionAllowed(fileName));

//         // Getting last modification time
//         System.out.println("Last modification time: " + getLastModificationTime(fileName));

//         // Creating a directory
//         createDirectory("exampleDirectory");

//         // Creating a file under created directory with extension .txt
//         createFileUnderDirectory("exampleDirectory", "exampleFile.txt");
//     }

//     // Method to create a file
//     public static void createFile(String fileName) {
//         File file = new File(fileName);
//         try {
//             if (file.createNewFile()) {
//                 System.out.println("File created: " + file.getName());
//             } else {
//                 System.out.println("File already exists.");
//             }
//         } catch (IOException e) {
//             System.out.println("An error occurred while creating the file.");
//             e.printStackTrace();
//         }
//     }

//     // Method to check if file is present
//     public static boolean isFilePresent(String fileName) {
//         File file = new File(fileName);
//         return file.exists();
//     }

//     // Method to get file name
//     public static String getFileName(String fileName) {
//         File file = new File(fileName);
//         return file.getName();
//     }

//     // Method to get path name
//     public static String getPathName(String fileName) {
//         File file = new File(fileName);
//         return file.getPath();
//     }

//     // Method to check if it's a file
//     public static boolean isFile(String fileName) {
//         File file = new File(fileName);
//         return file.isFile();
//     }

//     // Method to get file parent
//     public static String getFileParent(String fileName) {
//         File file = new File(fileName);
//         return file.getParent();
//     }

//     // Method to check if modification is allowed
//     public static boolean isModificationAllowed(String fileName) {
//         File file = new File(fileName);
//         return file.canWrite();
//     }

//     // Method to check if execution is allowed
//     public static boolean isExecutionAllowed(String fileName) {
//         File file = new File(fileName);
//         return file.canExecute();
//     }

//     // Method to get last modification time
//     public static long getLastModificationTime(String fileName) {
//         File file = new File(fileName);
//         return file.lastModified();
//     }

//     // Method to create a directory
//     public static void createDirectory(String directoryName) {
//         File directory = new File(directoryName);
//         if (directory.mkdirs()) {
//             System.out.println("Directory created: " + directory.getName());
//         } else {
//             System.out.println("Failed to create directory.");
//         }
//     }

//     // Method to create a file under a directory with extension .txt
//     public static void createFileUnderDirectory(String directoryName, String fileName) {
//         File file = new File(directoryName + File.separator + fileName);
//         try {
//             if (file.createNewFile()) {
//                 System.out.println("File created: " + file.getName());
//             } else {
//                 System.out.println("File already exists.");
//             }
//         } catch (IOException e) {
//             System.out.println("An error occurred while creating the file.");
//             e.printStackTrace();
//         }
//     }
// }

//part two
public class sixteen {
    private double balance = 1000; // Initial balance

    // Method to deposit money
    public synchronized void deposit(double amount) {
        System.out.println("Depositing: " + amount);
        balance += amount;
        System.out.println("New Balance after Deposit: " + balance);
        notify(); // Notify waiting thread
    }

    // Method to withdraw money
    public synchronized void withdraw(double amount) throws InterruptedException {
        while (balance < amount) {
            System.out.println("Insufficient Balance. Waiting for deposit...");
            wait(); // Wait for deposit
        }
        System.out.println("Withdrawing: " + amount);
        balance -= amount;
        System.out.println("New Balance after Withdrawal: " + balance);
    }

    public static void main(String[] args) {
        sixteen bank = new sixteen();

        // Consumer thread (Withdrawal)
        Thread consumerThread = new Thread(() -> {
            try {
                bank.withdraw(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Producer thread (Deposit)
        Thread producerThread = new Thread(() -> {
            bank.deposit(2000);
        });

        // Start threads
        consumerThread.start();
        producerThread.start();
    }
}
