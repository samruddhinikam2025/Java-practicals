import java.util.Scanner;

public class practical8SMS {

 public static void main(String[] args) {

 Scanner sc = new Scanner(System.in);
 Management m = new Management();

int choice;

do {

            System.out.println("\n--- Student Management System ---");
            System.out.println("1 Add Student");
            System.out.println("2 Display Students");
            System.out.println("3 Search Student");
            System.out.println("4 Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
            sc.nextLine();

switch (choice) {

                case 1:
                    m.addStudent(sc);
                    break;

                case 2:
                    m.displayStudents();
                    break;

                case 3:
                    m.searchStudent(sc);
                    break;
             case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 4);
  }
}

class Management {

 Student students[] = new Student[10];
 int count = 0;

 void addStudent(Scanner sc) {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Reg No: ");
        String regNo = sc.nextLine();

        System.out.print("Enter Contact No: ");
        String contactNo = sc.nextLine();

        students[count] = new Student(name, regNo, contactNo);
        count++;

        System.out.println("Student Added Successfully");
    }

void displayStudents() {

        for (int i = 0; i < count; i++) {
            students[i].display();
            System.out.println("----------------------");
        }
    }
 void searchStudent(Scanner sc) {

        System.out.print("Enter Reg No to Search: ");
        String reg = sc.nextLine();

        for (int i = 0; i < count; i++) {
            if (students[i].regNo.equals(reg)) {
                students[i].display();
                return;
            }
        }
 System.out.println("Student Not Found");
    }
}class Student {

    String name;
    String regNo;
    String contactNo;

    Student(String name, String regNo, String contactNo) {
        this.name = name;
        this.regNo = regNo;
        this.contactNo = contactNo;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Reg No: " + regNo);
        System.out.println("Contact No: " + contactNo);
    }
}