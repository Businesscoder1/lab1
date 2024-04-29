//part one
// import java.util.ArrayList;
// import java.util.Collections;

// public class seventeen {
//     public static void main(String[] args) {
//         // Create an ArrayList
//         ArrayList<Integer> arrayList = new ArrayList<>();

//         // Add elements to the ArrayList
//         arrayList.add(10);
//         arrayList.add(20);
//         arrayList.add(30);
//         arrayList.add(40);
//         arrayList.add(50);

//         // Display the original array
//         System.out.println("Original Array: " + arrayList);

//         // Add an element at specific index
//         arrayList.add(2, 25);
//         System.out.println("After adding 25 at index 2: " + arrayList);

//         // Remove an element at specific index
//         arrayList.remove(3);
//         System.out.println("After removing element at index 3: " + arrayList);

//         // Search for an element
//         int index = arrayList.indexOf(30);
//         if (index != -1) {
//             System.out.println("Element 30 found at index: " + index);
//         } else {
//             System.out.println("Element 30 not found");
//         }

//         // Fill the ArrayList with a specific value
//         Collections.fill(arrayList, 0);
//         System.out.println("After filling the array with 0: " + arrayList);

//         // Display the array in descending order
//         Collections.sort(arrayList, Collections.reverseOrder());
//         System.out.println("Array in descending order: " + arrayList);
//     }
// }

//part two
public class seventeen {
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
        seventeen bank = new seventeen();

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
