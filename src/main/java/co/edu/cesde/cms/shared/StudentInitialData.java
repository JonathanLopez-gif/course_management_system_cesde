package co.edu.cesde.cms.shared;

import co.edu.cesde.cms.domain.models.StudentModel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class StudentInitialData {

    public static List<StudentModel> getStudents() {
        List<StudentModel> students = new ArrayList<>();

        students.add(new StudentModel(
                1L,
                "Juan",
                "Pérez",
                "juan@correo.com",
                LocalDate.of(2000, 5, 10)
        ));

        students.add(new StudentModel(
                2L,
                "Ana",
                "Gómez",
                "ana@correo.com",
                LocalDate.of(2001, 8, 15)
        ));

        students.add(new StudentModel(
                3L,
                "Carlos",
                "Ruiz",
                "carlos@correo.com",
                LocalDate.of(1999, 12, 20)
        ));

        return students;
    }

}