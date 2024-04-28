// ///// P1

// public class six {
//     // Static data member
//     private static int staticData = 100;

//     // Non-static data member
//     private int nonStaticData = 200;

//     // Static method accessing static data member
//     public static void staticMethod() {
//         System.out.println("Static Method: Static Data = " + staticData);
//     }

//     // Non-static method accessing non-static data member
//     public void nonStaticMethod() {
//         System.out.println("Non-Static Method: Non-Static Data = " + nonStaticData);
//     }

//     // Static method accessing non-static data member (not allowed)
//     /*
//     public static void staticMethodAccessingNonStatic() {
//         System.out.println("Static Method accessing Non-Static Data: " + nonStaticData); // Compilation error
//     }
//     */

//     // Non-static method accessing static data member
//     public void nonStaticMethodAccessingStatic() {
//         System.out.println("Non-Static Method accessing Static Data: " + staticData);
//     }

//     // Static class
//     static class StaticNestedClass {
//         public void display() {
//             System.out.println("Static Nested Class");
//         }
//     }

//     // Non-static class
//     class NonStaticNestedClass {
//         public void display() {
//             System.out.println("Non-Static Nested Class");
//         }
//     }

//     public static void main(String[] args) {
//         // Accessing static method and static data member without creating an object
//         staticMethod();

//         // Accessing static nested class without creating an object
//         StaticNestedClass staticNestedClass = new StaticNestedClass();
//         staticNestedClass.display();

//         // Accessing non-static method and non-static data member by creating an object
//         six obj = new six();
//         obj.nonStaticMethod();

//         // Accessing non-static nested class by creating an object
//         NonStaticNestedClass nonStaticNestedClass = obj.new NonStaticNestedClass();
//         nonStaticNestedClass.display();
//     }
// }


/////// P2

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class six extends JFrame implements ActionListener {
    private JTextField textField1, textField2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton;

    public six() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create text fields
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false); // Result field is not editable

        // Create buttons
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");

        // Add action listeners to buttons
        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.add(textField1);
        panel.add(textField2);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(resultField);

        // Set layout and add panel to frame
        setLayout(new GridLayout(2, 1));
        add(panel);

        // Set frame visible
        setVisible(true);
    }

    // ActionListener implementation for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            int num1 = Integer.parseInt(textField1.getText());
            int num2 = Integer.parseInt(textField2.getText());
            int result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Error: Invalid input");
        } catch (ArithmeticException ex) {
            resultField.setText("Error: Division by zero");
        }
    }

    public static void main(String[] args) {
        new six();
    }
}
