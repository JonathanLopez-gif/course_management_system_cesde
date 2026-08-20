package co.edu.cesde.cms.application.services;

import co.edu.cesde.cms.application.repositories.StudentRepository;
import co.edu.cesde.cms.domain.models.StudentModel;

import java.util.List;
import java.util.Optional;

public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentModel create(StudentModel student) {
        return repository.save(student);
    }

    public Optional<StudentModel> getById(Long id) {
        return repository.findById(id);
    }

    public List<StudentModel> getAll() {
        return repository.findAll();
    }

    public StudentModel update(StudentModel student) {
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