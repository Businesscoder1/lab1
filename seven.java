// ///////////p1

// // ErrorDemo.java

// class seven {
//     public static void main(String[] args) {
//         final int x;
//         x = 10; // Error: cannot assign a value to final variable
//     }
// }

// class CannotOverrideMethodDemo {
//     public void display() {
//         System.out.println("Parent class method");
//     }
// }

// class ChildClass extends CannotOverrideMethodDemo {
//     @Override
//     public void display() {
//         System.out.println("Child class method");
//     }
// }

// final class CannotSubclassDemo {
//     public static void main(String[] args) {
//         // Error: cannot subclass a final class
//     }
// }


///////////P2

// MultiThreadDemo.java

import java.util.Random;

class NumberGenerator extends Thread {
    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            int num = random.nextInt(100); // generate random number
            System.out.println("Generated number: " + num);
            if (num % 2 == 0) {
                SquareThread squareThread = new SquareThread(num);
                squareThread.start();
            } else {
                CubeThread cubeThread = new CubeThread(num);
                cubeThread.start();
            }
            try {
                Thread.sleep(1000); // sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class SquareThread extends Thread {
    private int num;

    public SquareThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Square of " + num + " is: " + (num * num));
    }
}

class CubeThread extends Thread {
    private int num;

    public CubeThread(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        System.out.println("Cube of " + num + " is: " + (num * num * num));
    }
}

public class seven {
    public static void main(String[] args) {
        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.start();
    }
}
