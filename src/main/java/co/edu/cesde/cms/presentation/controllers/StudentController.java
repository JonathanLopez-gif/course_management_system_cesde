package co.edu.cesde.cms.presentation.controllers;

import co.edu.cesde.cms.application.services.StudentService;
import co.edu.cesde.cms.infrastructure.entities.StudentEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Tag(name = "Students", description = "Operations related to students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(
            summary = "Get all the students",
            description = "Returns the list of all registered students"
    )
    @GetMapping
    public List<StudentEntity> findAll() {
        return studentService.findAll();
    }

    @Operation(
            summary = "Get a student",
            description = "Look for a student by their ID number"
    )
    @GetMapping("/{id}")
    public StudentEntity findById(@PathVariable Long id) {
        return studentService.findById(id);
    }

    @Operation(
            summary = "Create a student",
            description = "Creates a new student"
    )
    @PostMapping
    public StudentEntity save(
            @Valid @RequestBody StudentEntity student) {

        return studentService.save(student);
    }

    @Operation(
            summary = "Update a student",
            description = "Updates an existing student"
    )
    @PutMapping("/{id}")
    public StudentEntity update(
            @PathVariable Long id,
            @Valid @RequestBody StudentEntity student) {

        return studentService.update(id, student);
    }

    @Operation(
            summary = "Delete a student",
            description = "Deletes a student by ID"
    )
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }

}