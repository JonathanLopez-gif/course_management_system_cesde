package co.edu.cesde.cms.shared;

import co.edu.cesde.cms.domain.models.CourseModel;

import java.util.ArrayList;
import java.util.List;

public class CourseInitialData {

    public static List<CourseModel> getCourses() {
        List<CourseModel> courses = new ArrayList<>();

        courses.add(new CourseModel(
                1L,
                "JAVA-101",
                "Java Fundamentals",
                "Curso básico de Java",
                30
        ));

        courses.add(new CourseModel(
                2L,
                "SPR-201",
                "Spring Boot",
                "Desarrollo de aplicaciones con Spring Boot",
                25
        ));

        courses.add(new CourseModel(
                3L,
                "DB-301",
                "Databases",
                "Fundamentos de bases de datos relacionales",
                20
        ));

        return courses;
    }

}