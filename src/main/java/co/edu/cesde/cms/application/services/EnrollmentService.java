package co.edu.cesde.cms.application.services;

import co.edu.cesde.cms.application.repositories.EnrollmentRepository;
import co.edu.cesde.cms.domain.models.EnrollmentModel;
import co.edu.cesde.cms.domain.models.EnrollmentStatus;

import java.util.List;
import java.util.Optional;

public class EnrollmentService {

    private final EnrollmentRepository repository;

    public EnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    public EnrollmentModel createEnrollment(EnrollmentModel enrollment) {
        return repository.save(enrollment);
    }

    public Optional<EnrollmentModel> getById(Long id) {
        return repository.findById(id);
    }

    public List<EnrollmentModel> getAll() {
        return repository.findAll();
    }

    public EnrollmentModel cancelEnrollment(Long id) {
        Optional<EnrollmentModel> optionalEnrollment = repository.findById(id);

        if (optionalEnrollment.isPresent()) {
            EnrollmentModel enrollment = optionalEnrollment.get();
            enrollment.setStatus(EnrollmentStatus.CANCELED);
            return repository.update(enrollment);
        }

        return null;
    }

    public boolean deleteEnrollment(Long id) {
        repository.deleteById(id);
        return false;
    }

}