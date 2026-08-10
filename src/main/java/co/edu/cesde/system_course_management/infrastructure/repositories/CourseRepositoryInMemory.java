package co.edu.cesde.system_course_management.infrastructure.repositories;

import co.edu.cesde.system_course_management.application.repositories.CourseRepository;
import co.edu.cesde.system_course_management.domain.models.Course;
import co.edu.cesde.system_course_management.shared.CourseInitialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepositoryInMemory implements CourseRepository {

    private final List<Course> storage = new ArrayList<>();

    public CourseRepositoryInMemory() {
        loadInitialData();
    }

    private void loadInitialData() {
        storage.addAll(CourseInitialData.getCourses());
    }

    @Override
    public Course save(Course course) {
        storage.add(course);
        return course;
    }

    @Override
    public Optional<Course> findById(Long id) {
        return storage.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<Course> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public Course update(Course course) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getId().equals(course.getId())) {
                storage.set(i, course);
                return course;
            }
        }

        return null;
    }

    @Override
    public void deleteById(Long id) {
        storage.removeIf(course -> course.getId().equals(id));
    }

    @Override
    public boolean existsById(Long id) {
        return storage.stream()
                .anyMatch(course -> course.getId().equals(id));
    }

}