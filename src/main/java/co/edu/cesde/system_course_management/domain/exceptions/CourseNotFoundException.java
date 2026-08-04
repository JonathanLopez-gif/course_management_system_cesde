package co.edu.cesde.system_course_management.domain.exceptions;

public class CourseNotFoundException extends BusinessException {

    public CourseNotFoundException(Long id) {
        super("Course with id " + id + " not found");
    }

}