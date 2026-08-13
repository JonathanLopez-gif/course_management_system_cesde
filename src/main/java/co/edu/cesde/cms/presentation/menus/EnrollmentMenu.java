package co.edu.cesde.cms.presentation.menus;

import co.edu.cesde.cms.application.services.EnrollmentService;
import co.edu.cesde.cms.domain.models.Enrollment;

import java.util.Scanner;

public class EnrollmentMenu {

    private final EnrollmentService enrollmentService;
    private Enrollment enrollment;

    private final Scanner scanner = new Scanner(System.in);

    public EnrollmentMenu(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

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

                case 1:
                    System.out.println("Enrollment created successfully!");
                    break;

                case 2:
                    System.out.println("Enrollment found successfully!");
                    break;

                case 3:
                    listAllEnrollments();
                    break;

                case 4:
                    System.out.println("Enrollment cancelled successfully!");
                    break;

                case 5:
                    System.out.println("Enrollment deleted successfully!");
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);
    }

    private void listAllEnrollments() {
        System.out.println("\n--- ENROLLMENT LIST ---");

        enrollmentService.getAll()
                .forEach(enrollment -> System.out.println(enrollment));
    }

}