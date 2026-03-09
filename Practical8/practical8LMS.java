import java.util.Scanner;

public class practical8LMS {

 public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

 int choice;

 do {

            System.out.println("\n--- Library Management System ---");
            System.out.println("1 Add Book");
            System.out.println("2 Issue Book");
            System.out.println("3 Return Book");
            System.out.println("4 Display Books");
            System.out.println("5 Exit");

   System.out.print("Enter Choice: ");
            choice = sc.nextInt();

   switch (choice) {

                case 1:
                    lib.addBook(sc);
                    break;

                case 2:
                    lib.issueBook(sc);
                    break;

                case 3:
                    lib.returnBook(sc);
                    break;

                case 4:
                    lib.displayBooks();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
    }
}class Library {

 Book books[] = new Book[10];
 int count = 0;

 void addBook(Scanner sc) {

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

      System.out.print("Enter Title: ");
      String title = sc.nextLine();

      System.out.print("Enter Author: ");
       String author = sc.nextLine();

        books[count] = new Book(id, title, author);
        count++;

        System.out.println("Book Added Successfully");
    }

 void issueBook(Scanner sc) {

  System.out.print("Enter Book ID to Issue: ");
  int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (books[i].bookId == id && !books[i].issued) {

                books[i].issued = true;
                System.out.println("Book Issued");
                return;
            }
        }

        System.out.println("Book Not Available");
    }

 void returnBook(Scanner sc) {

 System.out.print("Enter Book ID to Return: ");
  int id = sc.nextInt();

        for (int i = 0; i < count; i++) {

            if (books[i].bookId == id && books[i].issued) {

                books[i].issued = false;
                System.out.println("Book Returned");
                return;
            }
        }

        System.out.println("Invalid Book ID");
    }

 void displayBooks() {

 for (int i = 0; i < count; i++) {

            books[i].display();
            System.out.println("----------------");
        }
    }
}class Book {

    int bookId;
    String title;
    String author;
    boolean issued;

 Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        issued = false;
    }
 void display() {

        System.out.println("Book ID: " + bookId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Issued: " + issued);
    }
}