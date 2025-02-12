import Database.*;
import java.util.List;
import java.util.Scanner;

public class StudentManagement {
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Operation operation = new Operation();

        while(true)
        {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                    // Add Student
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("Enter student grade: ");
                    String grade = scanner.nextLine();

                    Student newStudent = new Student(0, name, age, grade);
                    operation.addStudent(newStudent);
                    break;

                case 2:
                    //View all Student
                    List<Student> students = operation.getAllStudents();
                    System.out.println("----Student List ----");
                    for (Student student : students)
                    {
                        System.out.println(student);
                    }
                    break;

                case 3:
                    //Update Student
                    System.out.print("Enter Student Id to Update : ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new age: ");
                    int newAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new grade: ");
                    String newGrade = scanner.nextLine();

                    operation.updateStudent(id,newName,newAge,newGrade);

                    break;

                case 4:
                    // Delete Student
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = scanner.nextInt();
                    operation.deleteStudent(deleteId);
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting Student Management System. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please enter a valid option.");
            }
        }
    }
}
