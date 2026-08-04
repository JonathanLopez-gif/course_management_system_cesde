package co.edu.cesde.system_course_management.application.repositories;

import co.edu.cesde.system_course_management.domain.models.Student;

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