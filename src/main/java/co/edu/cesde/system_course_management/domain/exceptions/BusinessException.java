package co.edu.cesde.system_course_management.domain.exceptions;

public class BusinessException extends RuntimeException {

    public BusinessException(String message) {
        super(message);
    }

}