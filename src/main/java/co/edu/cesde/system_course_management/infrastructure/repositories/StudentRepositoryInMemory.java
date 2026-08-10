package co.edu.cesde.system_course_management.infrastructure.repositories;

import co.edu.cesde.system_course_management.application.repositories.StudentRepository;
import co.edu.cesde.system_course_management.domain.models.Student;
import co.edu.cesde.system_course_management.shared.StudentInitialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryInMemory implements StudentRepository {

    private final List<Student> storage = new ArrayList<>();

    public StudentRepositoryInMemory() {
        loadInitialData();
    }

    private void loadInitialData() {
        storage.addAll(StudentInitialData.getStudents());
    }

    @Override
    public Student save(Student student) {
        storage.add(student);
        return student;
    }

    @Override
    public Optional<Student> findById(Long id) {
        return storage.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Student update(Student student) {
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