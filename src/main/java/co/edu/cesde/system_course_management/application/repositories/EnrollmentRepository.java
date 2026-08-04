package co.edu.cesde.system_course_management.application.repositories;

import co.edu.cesde.system_course_management.domain.models.Enrollment;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    Enrollment save(Enrollment enrollment);
    boolean existsById(Long id);
    Optional<Enrollment> findById(Long id);
    List<Enrollment> findAll();
    Enrollment update(Enrollment enrollment);
    void deleteById(Long id);

}