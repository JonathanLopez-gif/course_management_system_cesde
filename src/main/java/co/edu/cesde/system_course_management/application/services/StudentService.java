package co.edu.cesde.system_course_management.application.services;

import co.edu.cesde.system_course_management.application.repositories.StudentRepository;
import co.edu.cesde.system_course_management.domain.models.Student;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public Student create(Student student) {
        return repository.save(student);
    }

    public Optional<Student> getById(Long id) {
        return repository.findById(id);
    }

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student update(Student student) {
        return repository.update(student);
    }

    public boolean delete(Long id) {
        repository.deleteById(id);
        return false;
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

}