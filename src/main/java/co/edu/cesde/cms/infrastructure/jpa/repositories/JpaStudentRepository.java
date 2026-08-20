package co.edu.cesde.cms.infrastructure.jpa.repositories;

import co.edu.cesde.cms.application.repositories.StudentRepository;
import co.edu.cesde.cms.domain.models.StudentModel;
import co.edu.cesde.cms.shared.StudentInitialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaStudentRepository implements StudentRepository {

    private final List<StudentModel> storage = new ArrayList<>();

    public JpaStudentRepository() {
        loadInitialData();
    }

    private void loadInitialData() {
        storage.addAll(StudentInitialData.getStudents());
    }

    @Override
    public StudentModel save(StudentModel student) {
        storage.add(student);
        return student;
    }

    @Override
    public Optional<StudentModel> findById(Long id) {
        return storage.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<StudentModel> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public StudentModel update(StudentModel student) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId().equals(student.getId())) {
                storage.set(i, student);
                return student;
            }
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        storage.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public boolean existsById(Long id) {
        return storage.stream()
                .anyMatch(student -> student.getId().equals(id));
    }

}