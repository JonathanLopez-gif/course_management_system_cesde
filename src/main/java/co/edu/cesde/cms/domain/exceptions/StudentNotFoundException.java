package co.edu.cesde.cms.domain.exceptions;

public class StudentNotFoundException extends BusinessException {

    public StudentNotFoundException(Long id) {
        super("Student with id " + id + " not found");
    }

}