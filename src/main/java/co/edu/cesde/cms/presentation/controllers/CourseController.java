package co.edu.cesde.cms.presentation.controllers;

import co.edu.cesde.cms.application.services.CourseService;
import co.edu.cesde.cms.infrastructure.entities.CourseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/courses")
@Tag(name = "Courses", description = "Operations related to courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @Operation(
            summary = "Get all the courses",
            description = "Returns the list of all registered courses"
    )
    @GetMapping
    public List<CourseEntity> findAll() {
        return courseService.findAll();
    }

    @Operation(
            summary = "Get a course",
            description = "Look for a course by their ID number"
    )
    @GetMapping("/{id}")
    public Optional<CourseEntity> findById(@PathVariable Long id) {
        return courseService.findById(id);
    }

    @Operation(
            summary = "Create a course",
            description = "Creates a new course"
    )
    @PostMapping
    public CourseEntity save(
            @Valid @RequestBody CourseEntity course) {

        return courseService.save(course);
    }

    @Operation(
            summary = "Update a course",
            description = "Updates an existing course"
    )
    @PutMapping("/{id}")
    public CourseEntity update(
            @PathVariable Long id,
            @Valid @RequestBody CourseEntity course) {

        return courseService.update(id, course);
    }

    @Operation(
            summary = "Delete a course",
            description = "Deletes a course by ID"
    )
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        courseService.deleteById(id);
    }

}