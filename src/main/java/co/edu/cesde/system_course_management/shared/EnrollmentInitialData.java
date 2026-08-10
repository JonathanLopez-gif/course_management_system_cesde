package co.edu.cesde.system_course_management.shared;

import co.edu.cesde.system_course_management.domain.models.Course;
import co.edu.cesde.system_course_management.domain.models.Enrollment;
import co.edu.cesde.system_course_management.domain.models.EnrollmentStatus;
import co.edu.cesde.system_course_management.domain.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentInitialData {

    public static List<Enrollment> getEnrollments() {
        List<Enrollment> enrollments = new ArrayList<>();

        Student student1 = StudentInitialData.getStudents().get(0);
        Student student2 = StudentInitialData.getStudents().get(1);
        Student student3 = StudentInitialData.getStudents().get(2);

        Course course1 = CourseInitialData.getCourses().get(0);
        Course course2 = CourseInitialData.getCourses().get(1);
        Course course3 = CourseInitialData.getCourses().get(2);

        enrollments.add(new Enrollment(
                1L,
                student1.getId(),
                course1.getId(),
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        ));

        enrollments.add(new Enrollment(
                2L,
                student2.getId(),
                course2.getId(),
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        ));

        enrollments.add(new Enrollment(
                3L,
                student3.getId(),
                course3.getId(),
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        ));

        return enrollments;
    }

}