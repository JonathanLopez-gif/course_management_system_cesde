package co.edu.cesde.system_course_management.application.exceptions;

public class EnrollmentNotFoundException extends BusinessException {

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment with id " + id + " not found");
    }

}