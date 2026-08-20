package co.edu.cesde.cms.infrastructure.jpa.repositories;

import co.edu.cesde.cms.application.repositories.CourseRepository;
import co.edu.cesde.cms.domain.models.CourseModel;
import co.edu.cesde.cms.shared.CourseInitialData;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JpaCourseRepository implements CourseRepository {

    private final List<CourseModel> storage = new ArrayList<>();

    public JpaCourseRepository() {
        loadInitialData();
    }

    private void loadInitialData() {
        storage.addAll(CourseInitialData.getCourses());
    }

    @Override
    public CourseModel save(CourseModel course) {
        storage.add(course);
        return course;
    }

    @Override
    public Optional<CourseModel> findById(Long id) {
        return storage.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst();
    }

    @Override
    public List<CourseModel> findAll() {
        return new ArrayList<>(storage);
    }

    @Override
    public CourseModel update(CourseModel course) {
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