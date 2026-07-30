package co.edu.cesde.system_course_management.application.exceptions;

public class StudentNotFoundException extends BusinessException {

    public StudentNotFoundException(Long id) {
        super("Student with id " + id + " not found");
    }

}