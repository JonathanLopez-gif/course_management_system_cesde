package co.edu.cesde.cms.application.services;

import co.edu.cesde.cms.domain.exceptions.EnrollmentNotFoundException;
import co.edu.cesde.cms.infrastructure.entities.EnrollmentEntity;
import co.edu.cesde.cms.infrastructure.repositories.EnrollmentJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EnrollmentService {

    private final EnrollmentJpaRepository enrollmentRepository;

    public EnrollmentService(EnrollmentJpaRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public EnrollmentEntity save(EnrollmentEntity enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public boolean existsById(UUID id) {
        return enrollmentRepository.existsById(id);
    }

    public Optional<EnrollmentEntity> findById(UUID id) {
        return enrollmentRepository.findById(id);
    }

    public List<EnrollmentEntity> findAll() {
        return enrollmentRepository.findAll();
    }

    public EnrollmentEntity update(UUID id, EnrollmentEntity enrollment) {

        EnrollmentEntity existingEnrollment = enrollmentRepository.findById(id)
                .orElseThrow(() ->
                        new EnrollmentNotFoundException(id)
                );

        existingEnrollment.setStudent(enrollment.getStudent());
        existingEnrollment.setCourse(enrollment.getCourse());

        return enrollmentRepository.save(existingEnrollment);
    }

    public void deleteById(UUID id) {

        if (!enrollmentRepository.existsById(id)) {
            throw new EnrollmentNotFoundException(id);
        }

        enrollmentRepository.deleteById(id);
    }

}