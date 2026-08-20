package co.edu.cesde.cms.infrastructure.jpa.repositories;

import co.edu.cesde.cms.application.repositories.EnrollmentRepository;
import co.edu.cesde.cms.domain.models.EnrollmentModel;
import co.edu.cesde.cms.shared.EnrollmentInitialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaEnrollmentRepository implements EnrollmentRepository {

    private final List<EnrollmentModel> storage = new ArrayList<>();

    public JpaEnrollmentRepository() {
        loadInitialData();
    }

    private void loadInitialData() {
        storage.addAll(EnrollmentInitialData.getEnrollments());
    }

    @Override
    public EnrollmentModel save(EnrollmentModel enrollment) {
        storage.add(enrollment);
        return enrollment;
    }

    @Override
    public Optional<EnrollmentModel> findById(Long id) {
        return storage.stream()
                .filter(enrollment -> enrollment.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<EnrollmentModel> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public EnrollmentModel update(EnrollmentModel enrollment) {
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