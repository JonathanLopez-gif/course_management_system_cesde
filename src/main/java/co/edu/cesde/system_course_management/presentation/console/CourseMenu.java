package co.edu.cesde.system_course_management.presentation.console;

import java.util.Scanner;

public class CourseMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void show() {

        int option;

        do {
            System.out.println("\n===== COURSE MENU =====");
            System.out.println("1. Create");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Update");
            System.out.println("5. Delete");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1: System.out.println("Create Course");
                break;
                case 2: System.out.println("Find Course By Id");
                break;
                case 3: System.out.println("List All Courses");
                break;
                case 4: System.out.println("Update Course");
                break;
                case 5: System.out.println("Delete Course");
                break;
                case 0: System.out.println("Returning to Main Menu...");
                break;
                default: System.out.println("Invalid option");
            }

        } while (option != 0);
    }
}