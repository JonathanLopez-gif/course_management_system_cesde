package co.edu.cesde.cms.application.repositories;

import co.edu.cesde.cms.domain.models.EnrollmentModel;

import java.util.List;
import java.util.Optional;

public interface EnrollmentRepository {

    EnrollmentModel save(EnrollmentModel enrollment);
    boolean existsById(Long id);
    Optional<EnrollmentModel> findById(Long id);
    List<EnrollmentModel> findAll();
    EnrollmentModel update(EnrollmentModel enrollment);
    void deleteById(Long id);

}