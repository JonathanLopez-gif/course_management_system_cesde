package co.edu.cesde.cms.application.repositories;

import co.edu.cesde.cms.domain.models.Course;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    Course save(Course course);
    boolean existsById(Long id);
    Optional<Course> findById(Long id);
    List<Course> findAll();
    Course update(Course course);
    void deleteById(Long id);

}