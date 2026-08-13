package co.edu.cesde.cms.domain.exceptions;

public class CourseNotFoundException extends BusinessException {

    public CourseNotFoundException(Long id) {
        super("Course with id " + id + " not found");
    }

}