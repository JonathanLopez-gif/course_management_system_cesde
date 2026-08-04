package co.edu.cesde.system_course_management.application.services;

import co.edu.cesde.system_course_management.application.repositories.StudentRepository;
import co.edu.cesde.system_course_management.domain.exceptions.StudentNotFoundException;
import co.edu.cesde.system_course_management.domain.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentService implements StudentRepository {

    private final List<Student> students;

    public StudentService() {
        this.students = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if (existsById(student.getId())) {
            throw new IllegalArgumentException(
                    "Student with id " + student.getId() + " already exists"
            );
        }

        students.add(student);
        return student;
    }

    @Override
    public boolean existsById(Long id) {
        return students.stream()
                .anyMatch(student -> student.getId().equals(id));
    }

    @Override
    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }

    @Override
    public Student update(Student student) {

        Optional<Student> optionalStudent = findById(student.getId());

        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException(student.getId());
        }

        Student existingStudent = optionalStudent.get();

        int index = students.indexOf(existingStudent);
        students.set(index, student);

        return student;
    }

    @Override
    public void deleteById(Long id) {

        Optional<Student> optionalStudent = findById(id);

        if (optionalStudent.isEmpty()) {
            throw new StudentNotFoundException(id);
        }

        students.remove(optionalStudent.get());
    }

}