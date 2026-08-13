package co.edu.cesde.cms.shared;

import co.edu.cesde.cms.domain.models.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentInitialData {

    public static List<Student> getStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(
                1L,
                "Juan",
                "Pérez",
                "juan@correo.com",
                LocalDate.of(2000, 5, 10)
        ));

        students.add(new Student(
                2L,
                "Ana",
                "Gómez",
                "ana@correo.com",
                LocalDate.of(2001, 8, 15)
        ));

        students.add(new Student(
                3L,
                "Carlos",
                "Ruiz",
                "carlos@correo.com",
                LocalDate.of(1999, 12, 20)
        ));

        return students;
    }

}