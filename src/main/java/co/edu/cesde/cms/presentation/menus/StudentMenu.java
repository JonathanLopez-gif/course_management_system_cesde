package co.edu.cesde.cms.presentation.menus;

import co.edu.cesde.cms.application.services.StudentService;

import java.util.Scanner;

public class StudentMenu {

    private final StudentService studentService;
    private final Scanner scanner = new Scanner(System.in);

    public StudentMenu(StudentService studentService) {
        this.studentService = studentService;
    }

    public void show() {

        int option;

        do {
            System.out.println("\n===== STUDENT MENU =====");
            System.out.println("1. Create");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (option) {

                case 1:
                    System.out.println("Student created successfully!");
                    break;

                case 2:
                    System.out.println("Student found successfully!");
                    break;

                case 3:
                    listAllStudents();
                    break;

                case 4:
                    System.out.println("Student updated successfully!");
                    break;

                case 5:
                    System.out.println("Student deleted successfully!");
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);
    }

    private void listAllStudents() {
        System.out.println("\n--- STUDENT LIST ---");

        studentService.getAll()
                .forEach(student -> System.out.println(student));
    }

}