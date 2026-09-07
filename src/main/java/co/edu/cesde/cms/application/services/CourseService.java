package co.edu.cesde.cms.application.services;

import co.edu.cesde.cms.domain.exceptions.CourseNotFoundException;
import co.edu.cesde.cms.infrastructure.entities.CourseEntity;
import co.edu.cesde.cms.infrastructure.repositories.CourseJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CourseJpaRepository courseRepository;

    public CourseService(CourseJpaRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public CourseEntity save(CourseEntity course) {
        return courseRepository.save(course);
    }

    public boolean existsById(Long id) {
        return courseRepository.existsById(id);
    }

    public Optional<CourseEntity> findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<CourseEntity> findAll() {
        return courseRepository.findAll();
    }

    public CourseEntity update(Long id, CourseEntity course) {

        CourseEntity existingCourse = courseRepository.findById(id)
                .orElseThrow(() ->
                        new CourseNotFoundException(id)
                );

        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setMaxCapacity(course.getMaxCapacity());

        return courseRepository.save(existingCourse);
    }

    public void deleteById(Long id) {

        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException(id);
        }

        courseRepository.deleteById(id);
    }

}