package co.edu.cesde.cms.application.repositories;

import co.edu.cesde.cms.domain.models.CourseModel;

import java.util.List;
import java.util.Optional;

public interface CourseRepository {

    CourseModel save(CourseModel course);
    boolean existsById(Long id);
    Optional<CourseModel> findById(Long id);
    List<CourseModel> findAll();
    CourseModel update(CourseModel course);
    void deleteById(Long id);

}