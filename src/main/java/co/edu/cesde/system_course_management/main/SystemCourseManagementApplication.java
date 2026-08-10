package co.edu.cesde.system_course_management.main;

import co.edu.cesde.system_course_management.application.services.CourseService;
import co.edu.cesde.system_course_management.application.services.EnrollmentService;
import co.edu.cesde.system_course_management.application.services.StudentService;
import co.edu.cesde.system_course_management.domain.models.Student;
import co.edu.cesde.system_course_management.infrastructure.repositories.CourseRepositoryInMemory;
import co.edu.cesde.system_course_management.infrastructure.repositories.EnrollmentRepositoryInMemory;
import co.edu.cesde.system_course_management.infrastructure.repositories.StudentRepositoryInMemory;
import co.edu.cesde.system_course_management.presentation.menus.CourseMenu;
import co.edu.cesde.system_course_management.presentation.menus.EnrollmentMenu;
import co.edu.cesde.system_course_management.presentation.menus.MainMenu;
import co.edu.cesde.system_course_management.presentation.menus.StudentMenu;

import java.util.Scanner;

public class SystemCourseManagementApplication {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// Repositories
		StudentRepositoryInMemory studentRepository =
				new StudentRepositoryInMemory();

		CourseRepositoryInMemory courseRepository =
				new CourseRepositoryInMemory();

		EnrollmentRepositoryInMemory enrollmentRepository =
				new EnrollmentRepositoryInMemory();

		// Services
		StudentService studentService =
				new StudentService(studentRepository);

		CourseService courseService =
				new CourseService(courseRepository);

		EnrollmentService enrollmentService =
				new EnrollmentService(enrollmentRepository);

		// Menus
		MainMenu mainMenu = new MainMenu();

		StudentMenu studentMenu =
				new StudentMenu(studentService);

		CourseMenu courseMenu =
				new CourseMenu(courseService);

		EnrollmentMenu enrollmentMenu =
				new EnrollmentMenu(enrollmentService);

		int option;

		do {

			mainMenu.show();

			option = scanner.nextInt();

			switch (option) {

				case 1:
					studentMenu.show();
					break;

				case 2:
					courseMenu.show();
					break;

				case 3:
					enrollmentMenu.show();
					break;

				case 0:
					System.out.println("Good bye!");
					break;

				default:
					System.out.println("Invalid option");
			}

		} while (option != 0);

		scanner.close();
	}
}