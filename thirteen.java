//part one
// import java.io.*;

// public class thirteen {
//     public static void main(String[] args) {
//         String inputFileName = "input.txt";
//         String outputFileName = "output.txt";
//         int bufferSize = 30;

//         try {
//             // Read content from input file
//             FileInputStream inputStream = new FileInputStream(inputFileName);
//             byte[] buffer = new byte[bufferSize];
//             int bytesRead;
//             int readOperations = 0;
//             while ((bytesRead = inputStream.read(buffer)) != -1) {
//                 readOperations++;
//                 // Process buffer (e.g., print content)
//                 System.out.write(buffer, 0, bytesRead);
//             }
//             inputStream.close();
//             System.out.println("\nRead operations required: " + readOperations);

//             // Write content to output file
//             String contentToWrite = "This is the content to write to the file.";
//             FileOutputStream outputStream = new FileOutputStream(outputFileName);
//             byte[] contentBytes = contentToWrite.getBytes();
//             int writeOperations = (int) Math.ceil((double) contentBytes.length / bufferSize);
//             for (int i = 0; i < contentBytes.length; i += bufferSize) {
//                 int length = Math.min(bufferSize, contentBytes.length - i);
//                 outputStream.write(contentBytes, i, length);
//             }
//             outputStream.close();
//             System.out.println("Write operations required: " + writeOperations);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }

//part two
import java.util.*;

public class thirteen {
    private List<Integer> array;

    public thirteen() {
        array = new ArrayList<>();
    }

    public void insert(int element) {
        int index = Collections.binarySearch(array, element);
        if (index < 0) {
            index = -(index + 1);
        }
        array.add(index, element);
    }

    public void delete(int element) {
        int index = array.indexOf(element);
        if (index != -1) {
            array.remove(index);
        }
    }

    public boolean search(int element) {
        return array.contains(element);
    }

    public void display() {
        System.out.println("Array elements:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        thirteen sortedArray = new thirteen();
        sortedArray.insert(10);
        sortedArray.insert(5);
        sortedArray.insert(15);
        sortedArray.insert(3);
        sortedArray.insert(8);

        sortedArray.display(); // Output: Array elements: 3 5 8 10 15

        sortedArray.delete(5);

        sortedArray.display(); // Output: Array elements: 3 8 10 15

        System.out.println("Is 8 present in the array? " + sortedArray.search(8)); // Output: true
        System.out.println("Is 20 present in the array? " + sortedArray.search(20)); // Output: false
    }
}
