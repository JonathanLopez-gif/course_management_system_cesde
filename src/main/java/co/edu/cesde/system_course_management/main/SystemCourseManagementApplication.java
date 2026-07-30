package co.edu.cesde.system_course_management.main;

import co.edu.cesde.system_course_management.presentation.console.CourseMenu;
import co.edu.cesde.system_course_management.presentation.console.EnrollmentMenu;
import co.edu.cesde.system_course_management.presentation.console.MainMenu;
import co.edu.cesde.system_course_management.presentation.console.StudentMenu;

import java.util.Scanner;

public class SystemCourseManagementApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		CourseMenu courseMenu = new CourseMenu();
		EnrollmentMenu enrollmentMenu = new EnrollmentMenu();
		MainMenu mainMenu = new MainMenu();
		StudentMenu studentMenu = new StudentMenu();

		int option;

		do {
			mainMenu.show();

			option = scanner.nextInt();

			switch (option) {
				case 1: studentMenu.show();
				break;
				case 2: courseMenu.show();
				break;
				case 3: enrollmentMenu.show();
				break;
				case 0: System.out.println("Good bye!");
				break;
				default: System.out.println("Invalid option");
			}

		} while (option != 0);

		scanner.close();
	}
}