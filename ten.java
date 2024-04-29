import java.util.ArrayList;
import java.util.List;

public class ten {
    private Librarian librarian;
    private List<Book> books;
    private List<Student> students;

    public ten() {
        librarian = new Librarian("John", "LIB001");
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public void issueBook(Student student, Book book) {
        librarian.issueBook(student, book);
    }

    public void returnBook(Student student, Book book) {
        librarian.returnBook(student, book);
    }

    public class Librarian {
        private String name;
        private String id;

        public Librarian(String name, String id) {
            this.name = name;
            this.id = id;
        }

        public void issueBook(Student student, Book book) {
            if (books.contains(book) && book.isAvailable()) {
                book.borrow();
                student.borrowBook(book);
                System.out.println("Book issued to " + student.getName());
            } else {
                System.out.println("Book is not available for issue.");
            }
        }

        public void returnBook(Student student, Book book) {
            if (student.returnBook(book)) {
                book.returnBook();
                System.out.println("Book returned by " + student.getName());
            }
        }
    }

    public class Book {
        private String title;
        private String author;
        private String isbn;
        private boolean available;

        public Book(String title, String author, String isbn) {
            this.title = title;
            this.author = author;
            this.isbn = isbn;
            this.available = true;
        }

        public String getTitle() {
            return title;
        }

        public boolean isAvailable() {
            return available;
        }

        public void borrow() {
            available = false;
        }

        public void returnBook() {
            available = true;
        }
    }

    public class Student {
        private String name;
        private String rollNumber;

        public Student(String name, String rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
        }

        public String getName() {
            return name;
        }

        public void borrowBook(Book book) {
            System.out.println(name + " borrowed book: " + book.getTitle());
        }

        public boolean returnBook(Book book) {
            if (!book.isAvailable()) {
                return false;
            }
            System.out.println(name + " returned book: " + book.getTitle());
            return true;
        }
    }

    public static void main(String[] args) {
        ten librarySystem = new ten();
        ten.Book book1 = librarySystem.new Book("Java Programming", "John Doe", "123456789");
        ten.Book book2 = librarySystem.new Book("Data Structures", "Jane Smith", "987654321");
        ten.Student student1 = librarySystem.new Student("Alice", "S001");
        librarySystem.addBook(book1);
        librarySystem.addBook(book2);
        librarySystem.addStudent(student1);
        librarySystem.issueBook(student1, book1);
        librarySystem.returnBook(student1, book1);
    }
}
