package co.edu.cesde.cms.application.repositories;

import co.edu.cesde.cms.domain.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student save(Student student);
    boolean existsById(Long id);
    Optional<Student> findById(Long id);
    List<Student> findAll();
    Student update(Student student);
    void deleteById(Long id);

}