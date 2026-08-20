package co.edu.cesde.cms.shared;

import co.edu.cesde.cms.domain.models.CourseModel;
import co.edu.cesde.cms.domain.models.EnrollmentModel;
import co.edu.cesde.cms.domain.models.EnrollmentStatus;
import co.edu.cesde.cms.domain.models.StudentModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentInitialData {

    public static List<EnrollmentModel> getEnrollments() {
        List<EnrollmentModel> enrollments = new ArrayList<>();

        StudentModel student1 = StudentInitialData.getStudents().get(0);
        StudentModel student2 = StudentInitialData.getStudents().get(1);
        StudentModel student3 = StudentInitialData.getStudents().get(2);

        CourseModel course1 = CourseInitialData.getCourses().get(0);
        CourseModel course2 = CourseInitialData.getCourses().get(1);
        CourseModel course3 = CourseInitialData.getCourses().get(2);

        enrollments.add(new EnrollmentModel(
                1L,
                student1.getId(),
                course1.getId(),
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        ));

        enrollments.add(new EnrollmentModel(
                2L,
                student2.getId(),
                course2.getId(),
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        ));

        enrollments.add(new EnrollmentModel(
                3L,
                student3.getId(),
                course3.getId(),
                LocalDate.now(),
                EnrollmentStatus.ACTIVE
        ));

        return enrollments;
    }

}