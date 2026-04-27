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
public class Addstudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
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
        scanner.close();
    }
}