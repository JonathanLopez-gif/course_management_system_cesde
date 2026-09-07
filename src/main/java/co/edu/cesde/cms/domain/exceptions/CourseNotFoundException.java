package co.edu.cesde.cms.domain.exceptions;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException(Long id) {
        super("Course with id " + id + " not found");
    }

}