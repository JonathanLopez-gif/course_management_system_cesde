package co.edu.cesde.cms.domain.exceptions;

public class EnrollmentNotFoundException extends BusinessException {

    public EnrollmentNotFoundException(Long id) {
        super("Enrollment with id " + id + " not found");
    }

}