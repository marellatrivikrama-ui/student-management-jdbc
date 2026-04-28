import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
class Student {
    String name;
    int age;
    String firstname;
    String lastname;
    long aadharnumber; 
    String address;    
    int id;
    int ssalc;
    Student(String name, int age, String firstname, String lastname, long aadharnumber, String address, int id,int ssalc) {
        this.name = name;
        this.age = age;
        this.firstname = firstname;
        this.lastname = lastname;
        this.aadharnumber = aadharnumber;
        this.address = address;
        this.id = id;
        this.ssalc = ssalc;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age +"\n  First Name: " + firstname + ", Last Name: " + lastname +"\n  Aadhar: " + aadharnumber + ", Address: " + address + ",class:" + ssalc + "\n";
    }
}
public class StudentManagementSystem {
    public static ArrayList<Student> students = new ArrayList<>();
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args)throws InterruptedException {
        System.out.print("What do you wnat to do? \n 1. Add Student \n 2. View Students \n 3. Edit Student \n 4. Delete Student \n 5. Exit\n");
        int choice = scanner.nextInt();
        scanner.nextLine();
        while(true){
        switch (choice) {
            case 1: 
            Add_Studentlogic();
            break;
            case 2: View_Studentslogic();
            break;      
            case 3: Edit_Studentlogic();
            break;
            case 4: Delete_Studentlogic();
            break;
            case 5: System.out.println("Exiting...");   
            break;
            default: throw new IllegalArgumentException("Invalid choice: " + choice);
        }
        scanner.close();
    }
    }
    public static void Add_Studentlogic(){
        while (true) {
            int ssalc = -1;
            int age = -1;
            boolean isValid = false;
            System.out.println("After completion enert done");
            System.out.println("--- Enter Student Details ---");
            System.out.println("Enter your full name like (\"surname.namme\")");
            System.out.print("Enter full name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break; 
            }
            while (!isValid) {
                try {
                    System.out.print("Enter student class: ");
                    ssalc = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Age: ");
                    age = scanner.nextInt();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number for Class and Age.");
                    scanner.nextLine(); 
                    continue; 
                }
                
                if (ssalc == 10 && age < 14) {
                    System.out.println("Student is not allowed to study 10th class (min age is 14). Please re-enter Class and Age.");
                } else {
                    isValid = true;
                }
            }
            System.out.print("Enter First Name: ");
            String firstname = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastname = scanner.nextLine();
            System.out.print("Enter Aadhar Number: ");
            long aadharnumber = scanner.nextLong(); 
            scanner.nextLine(); 
            System.out.print("Enter Address: ");
            String address = scanner.nextLine();
            System.out.print("Enter ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); 
            System.out.println("id is your password for login purpose\nSo please remember it");
            Student newStudent = new Student(name, age, firstname, lastname, aadharnumber, address, id, ssalc);
            students.add(newStudent);
            System.out.println("Student added successfully.");
        }
    }
   public static void View_Studentslogic(){
    System.out.println("Enter you options \n 1. View all students \n 2. Search by ID \n 3. Search by Name \n 4. Back to Main Menu");
    int option = scanner.nextInt();
    scanner.nextLine();
    switch (option) {
        case 1:
            if (students.isEmpty()) {
                System.out.println("No students found.");
            } else {
                System.out.println("--- Student List ---");
                for (Student student : students) {
                    System.out.println(student);
                }
            }
            break;
        case 2:
            System.out.print("Enter ID to search: ");
            int searchId = scanner.nextInt();
            scanner.nextLine();
            boolean foundById = false;
            for (Student student : students) {
                if (student.id == searchId) {
                    System.out.println(student);
                    foundById = true;
                    break;
                }
            }
            if (!foundById) {
                System.out.println("Student with ID " + searchId + " not found.");
            }
            break;
        case 3:
            System.out.print("Enter Name to search: ");
            String searchName = scanner.nextLine();
            boolean foundByName = false;
            for (Student student : students) {
                if (student.name.equalsIgnoreCase(searchName)) {
                    System.out.println(student);
                    foundByName = true;
                }
            }
            if (!foundByName) {
                System.out.println("Student with Name " + searchName + " not found.");
            }
            break;
        case 4:
            // Back to Main Menu
            break;
        default:
            System.out.println("Invalid option.");
    }
   }
   public static void Edit_Studentlogic(){
    System.out.print("Enter ID of the student to edit: ");
    int editId = scanner.nextInt();
    scanner.nextLine();
    Student studentToEdit = null;
    for (Student student : students) {
        if (student.id == editId) {
            studentToEdit = student;
            break;
        }
    }
    if (studentToEdit == null) {
        System.out.println("Student with ID " + editId + " not found.");
        return;
    }
    System.out.println("Editing Student: " + studentToEdit);
    System.out.print("Enter new full name (or press Enter to keep current): ");
    String newName = scanner.nextLine();
    if (!newName.isEmpty()) {
        studentToEdit.name = newName;
    }
    System.out.print("Enter new age (or press Enter to keep current): ");
    String newAgeInput = scanner.nextLine();
    if (!newAgeInput.isEmpty()) {
        try {
            int newAge = Integer.parseInt(newAgeInput);
            studentToEdit.age = newAge;
        } catch (NumberFormatException e) {
            System.out.println("Invalid age input. Age not updated.");
        }
    }
    System.out.print("Enter new first name (or press Enter to keep current): ");
    String newFirstName = scanner.nextLine();
    if (!newFirstName.isEmpty()) {
        studentToEdit.firstname = newFirstName;
    }
    System.out.print("Enter new last name (or press Enter to keep current): ");
    String newLastName = scanner.nextLine();
    if (!newLastName.isEmpty()) {
        studentToEdit.lastname = newLastName;
    }
    System.out.print("Enter new Aadhar number (or press Enter to keep current): ");
    String newAadharInput = scanner.nextLine();
    if (!newAadharInput.isEmpty()) {
        try {
            long newAadharNumber = Long.parseLong(newAadharInput);
            studentToEdit.aadharnumber = newAadharNumber;
        } catch (NumberFormatException e) {
            System.out.println("Invalid Aadhar number input. Aadhar number not updated.");
        }
    }
    System.out.print("Enter new address (or press Enter to keep current): ");
    String newAddress = scanner.nextLine();
    if (!newAddress.isEmpty()) {
        studentToEdit.address = newAddress;
    }
    System.out.print("Enter new class (or press Enter to keep current): ");
    String newssalcInput = scanner.nextLine();
    if (!newssalcInput.isEmpty()) {
        studentToEdit.ssalc = newssalcInput.equalsIgnoreCase("done") ? studentToEdit.ssalc : Integer.parseInt(newssalcInput);
    }
    System.out.println("Student updated successfully.");
 }
 public static void Delete_Studentlogic(){
    System.out.print("Enter ID of the student to delete: ");
    int deleteId = scanner.nextInt();
    scanner.nextLine();
    Student studentToDelete = null;
    for (Student student : students) {
        if (student.id == deleteId) {
            studentToDelete = student;
            break;
        }
    }
    if (studentToDelete == null) {
        System.out.println("Student with ID " + deleteId + " not found.");
        return;
    }
    students.remove(studentToDelete);
    System.out.println("Student deleted successfully.");
   }
}
