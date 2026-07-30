package co.edu.cesde.system_course_management.presentation.console;

import java.util.Scanner;

public class EnrollmentMenu {

    private final Scanner scanner = new Scanner(System.in);

    public void show() {

        int option;

        do {
            System.out.println("\n===== ENROLLMENT MENU =====");
            System.out.println("1. Create Enrollment");
            System.out.println("2. Find By Id");
            System.out.println("3. List All");
            System.out.println("4. Cancel Enrollment");
            System.out.println("5. Delete Enrollment");
            System.out.println("0. Back");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1: System.out.println("Create Enrollment");
                break;
                case 2: System.out.println("Find Enrollment By Id");
                break;
                case 3: System.out.println("List All Enrollments");
                break;
                case 4: System.out.println("Cancel Enrollment");
                break;
                case 5: System.out.println("Delete Enrollment");
                break;
                case 0: System.out.println("Returning to Main Menu...");
                break;
                default: System.out.println("Invalid option");
            }

        } while (option != 0);
    }
}