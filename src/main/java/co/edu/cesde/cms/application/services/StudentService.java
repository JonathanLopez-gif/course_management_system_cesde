package co.edu.cesde.cms.application.services;

import co.edu.cesde.cms.domain.exceptions.StudentNotFoundException;
import co.edu.cesde.cms.infrastructure.entities.StudentEntity;
import co.edu.cesde.cms.infrastructure.repositories.StudentJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentJpaRepository studentRepository;

    public StudentService(StudentJpaRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<StudentEntity> findAll() {
        return studentRepository.findAll();
    }

    public StudentEntity findById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(id)
                );
    }

    public StudentEntity save(StudentEntity student) {
        return studentRepository.save(student);
    }

    public StudentEntity update(Long id, StudentEntity student) {

        StudentEntity existingStudent = studentRepository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException(id)
                );

        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setBirthDate(student.getBirthDate());
        existingStudent.setEnrollmentStatus(student.getEnrollmentStatus());

        return studentRepository.save(existingStudent);
    }

    public void deleteById(Long id) {

        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException(id);
        }

        studentRepository.deleteById(id);
    }

}