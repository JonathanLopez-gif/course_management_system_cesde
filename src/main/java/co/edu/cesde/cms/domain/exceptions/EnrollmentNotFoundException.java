package co.edu.cesde.cms.domain.exceptions;

import java.util.UUID;

public class EnrollmentNotFoundException extends RuntimeException {

    public EnrollmentNotFoundException(UUID id) {
        super("Enrollment with id " + id + " not found");
    }

}