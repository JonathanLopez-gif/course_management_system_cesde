package co.edu.cesde.system_course_management.infrastructure.repositories;

import co.edu.cesde.system_course_management.application.repositories.EnrollmentRepository;
import co.edu.cesde.system_course_management.domain.models.Enrollment;
import co.edu.cesde.system_course_management.shared.EnrollmentInitialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EnrollmentRepositoryInMemory implements EnrollmentRepository {

    private final List<Enrollment> storage = new ArrayList<>();

    public EnrollmentRepositoryInMemory() {
        loadInitialData();
    }

    private void loadInitialData() {
        storage.addAll(EnrollmentInitialData.getEnrollments());
    }

    @Override
    public Enrollment save(Enrollment enrollment) {
        storage.add(enrollment);
        return enrollment;
    }

    @Override
    public Optional<Enrollment> findById(Long id) {
        return storage.stream()
                .filter(enrollment -> enrollment.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Enrollment update(Enrollment enrollment) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId().equals(enrollment.getId())) {
                storage.set(i, enrollment);
                return enrollment;
            }
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        storage.removeIf(enrollment -> enrollment.getId().equals(id));
    }

    @Override
    public boolean existsById(Long id) {
        return storage.stream()
                .anyMatch(enrollment -> enrollment.getId().equals(id));
    }

}