// public class three {
//     private int myNumber;

//     // Constructor with no parameters
//     public three() {
//         this.myNumber = 0;
//     }

//     // Constructor with one parameter
//     public three(int number) {
//         this.myNumber = number;
//     }

//     // Overloaded constructor with two parameters
//     public three(int number1, int number2) {
//         this.myNumber = number1 + number2;
//     }

//     // Method to get the value of myNumber
//     public int getMyNumber() {
//         return myNumber;
//     }

//     // Inner static class
//     public static class InnerStaticClass {
//         public void display() {
//             System.out.println("This is inner static class.");
//         }
//     }

//     // Inner non-static class
//     public class InnerNonStaticClass {
//         public void display() {
//             System.out.println("This is inner non-static class.");
//         }
//     }

//     public static void main(String[] args) {
//         // Creating objects of MyClass using different constructors
//         three obj1 = new three();
//         three obj2 = new three(5);
//         three obj3 = new three(3, 4);

//         // Printing values of myNumber for each object
//         System.out.println("Value of obj1: " + obj1.getMyNumber());
//         System.out.println("Value of obj2: " + obj2.getMyNumber());
//         System.out.println("Value of obj3: " + obj3.getMyNumber());

//         // Using inner static class
//         three.InnerStaticClass staticObj = new three.InnerStaticClass();
//         staticObj.display();

//         // Using inner non-static class
//         three.InnerNonStaticClass nonStaticObj = obj1.new InnerNonStaticClass();
//         nonStaticObj.display();
//     }
// }

//////part 2

// Parent class
class Parent {
    private int privateVar = 10;
    protected int protectedVar = 20;
    public int publicVar = 30;

    // Method to demonstrate method overriding
    public void display() {
        System.out.println("Display method in Parent class.");
    }
}

// Child class inheriting from Parent class
class Child extends Parent {
    // Method overriding
    @Override
    public void display() {
        System.out.println("Display method in Child class.");
    }
}

public class three {
    public static void main(String[] args) {
        // Creating object of Child class
        Child childObj = new Child();

        // Accessing variables from Parent class
        System.out.println("Protected variable from Parent class: " + childObj.protectedVar);
        System.out.println("Public variable from Parent class: " + childObj.publicVar);

        // Calling overridden method
        childObj.display();
    }
}
