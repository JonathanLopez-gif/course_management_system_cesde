package co.edu.cesde.system_course_management.domain.exceptions;

public class EnrollmentNotFoundException extends BusinessException {

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment with id " + id + " not found");
    }

}