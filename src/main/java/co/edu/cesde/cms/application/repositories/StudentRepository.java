package co.edu.cesde.cms.application.repositories;

import co.edu.cesde.cms.domain.models.StudentModel;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    StudentModel save(StudentModel student);
    boolean existsById(Long id);
    Optional<StudentModel> findById(Long id);
    List<StudentModel> findAll();
    StudentModel update(StudentModel student);
    void deleteById(Long id);

}