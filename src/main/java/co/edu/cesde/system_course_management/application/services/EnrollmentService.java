package co.edu.cesde.system_course_management.application.services;

import co.edu.cesde.system_course_management.application.repositories.EnrollmentRepository;
import co.edu.cesde.system_course_management.domain.models.Enrollment;
import co.edu.cesde.system_course_management.domain.models.EnrollmentStatus;

import java.util.List;
import java.util.Optional;

public class EnrollmentService {

    private final EnrollmentRepository repository;

    public EnrollmentService(EnrollmentRepository repository) {
        this.repository = repository;
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return repository.save(enrollment);
    }

    public Optional<Enrollment> getById(Long id) {
        return repository.findById(id);
    }

    public List<Enrollment> getAll() {
        return repository.findAll();
    }

    public Enrollment cancelEnrollment(Long id) {
        Optional<Enrollment> optionalEnrollment = repository.findById(id);

        if (optionalEnrollment.isPresent()) {
            Enrollment enrollment = optionalEnrollment.get();
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