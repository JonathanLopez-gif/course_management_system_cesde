package co.edu.cesde.cms.application.services;

import co.edu.cesde.cms.application.repositories.CourseRepository;
import co.edu.cesde.cms.domain.models.CourseModel;

import java.util.List;
import java.util.Optional;

public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public CourseModel create(CourseModel course) {
        return repository.save(course);
    }

    public Optional<CourseModel> getById(Long id) {
        return repository.findById(id);
    }

    public List<CourseModel> getAll() {
        return repository.findAll();
    }

    public CourseModel update(CourseModel course) {
        return repository.update(course);
    }

    public boolean delete(Long id) {
        repository.deleteById(id);
        return false;
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }

}