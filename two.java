// Part i: Multilevel Inheritance
// Base class
class Base {
    private int privateVar = 10;
    protected int protectedVar = 20;
    public int publicVar = 30;

    final void finalMethod() {
        System.out.println("This is a final method in Base class.");
    }

    static void staticMethod() {
        System.out.println("This is a static method in Base class.");
    }

    void display() {
        System.out.println("Private var: " + privateVar);
        System.out.println("Protected var: " + protectedVar);
        System.out.println("Public var: " + publicVar);
    }
}

// Intermediate class inheriting Base class
abstract class Intermediate extends Base {
    // Non-access modifier: final
    final int finalVar = 40;

    // Non-access modifier: static
    static int staticVar = 50;

    // Non-access modifier: abstract
    abstract void abstractMethod();

    // Non-access modifier: synchronized
    synchronized void synchronizedMethod() {
        System.out.println("This is a synchronized method in Intermediate class.");
    }

    // Non-access modifier: transient
    transient int transientVar = 60;
}

// Derived class inheriting Intermediate class
public class two extends Intermediate {
    // Non-access modifier: volatile
    volatile int volatileVar = 70;

    @Override
    void abstractMethod() {
        System.out.println("This is an implementation of abstract method in Main class.");
    }

    public static void main(String[] args) {
        // Part i: Demonstrate multilevel inheritance
        two obj = new two();
        obj.display();
        obj.finalMethod();
        Base.staticMethod(); // Accessing static method from Base class

        // Part ii: Multi-thread application
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    int randomNumber = (int) (Math.random() * 100);
                    System.out.println("Random Number generated: " + randomNumber);
                    if (randomNumber % 2 == 0) {
                        // Create and start second thread to compute square
                        Thread t2 = new Thread(new SquareThread(randomNumber));
                        t2.start();
                    } else {
                        // Create and start third thread to compute cube
                        Thread t3 = new Thread(new CubeThread(randomNumber));
                        t3.start();
                    }
                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        t1.start();
    }
}

// Thread for computing square of even numbers
class SquareThread implements Runnable {
    private int number;

    public SquareThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Square of " + number + ": " + (number * number));
    }
}

// Thread for computing cube of odd numbers
class CubeThread implements Runnable {
    private int number;

    public CubeThread(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("Cube of " + number + ": " + (number * number * number));
    }
}

