package co.edu.cesde.cms.presentation.menus;

import co.edu.cesde.cms.application.services.CourseService;
import co.edu.cesde.cms.domain.models.Course;

import java.util.Scanner;

public class CourseMenu {

    private final CourseService courseService;
    private Course course;

    private final Scanner scanner = new Scanner(System.in);

    public CourseMenu(CourseService courseService) {
        this.courseService = courseService;
    }

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

                case 1:
                    System.out.println("Course created successfully!");
                    break;

                case 2:
                    System.out.println("Course found successfully!");
                    break;

                case 3:
                    listAllCourses();
                    break;

                case 4:
                    System.out.println("Course updated successfully!");
                    break;

                case 5:
                    System.out.println("Course deleted successfully!");
                    break;

                case 0:
                    System.out.println("Returning to Main Menu...");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        } while (option != 0);
    }

    private void listAllCourses() {
        System.out.println("\n--- COURSE LIST ---");

        courseService.getAll()
                .forEach(course -> System.out.println(course));
    }

}