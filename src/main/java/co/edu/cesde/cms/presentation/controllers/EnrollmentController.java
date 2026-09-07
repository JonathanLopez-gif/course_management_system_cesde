package co.edu.cesde.cms.presentation.controllers;

import co.edu.cesde.cms.application.services.EnrollmentService;
import co.edu.cesde.cms.infrastructure.entities.EnrollmentEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/enrollments")
@Tag(name = "Enrollments", description = "Operations related to enrollments")
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    @Operation(
            summary = "Get all the enrollments",
            description = "Returns the list of all registered enrollments"
    )
    @GetMapping
    public List<EnrollmentEntity> findAll() {
        return enrollmentService.findAll();
    }

    @Operation(
            summary = "Get a enrollment",
            description = "Look for a enrollment by their ID number"
    )
    @GetMapping("/{id}")
    public Optional<EnrollmentEntity> findById(@PathVariable UUID id) {
        return enrollmentService.findById(id);
    }

    @Operation(
            summary = "Create a enrollment",
            description = "Creates a new enrollment"
    )
    @PostMapping
    public EnrollmentEntity save(
            @Valid @RequestBody EnrollmentEntity enrollment) {

        return enrollmentService.save(enrollment);
    }

    @Operation(
            summary = "Update a enrollment",
            description = "Updates an existing enrollment"
    )
    @PutMapping("/{id}")
    public EnrollmentEntity update(
            @PathVariable UUID id,
            @Valid @RequestBody EnrollmentEntity enrollment) {

        return enrollmentService.update(id, enrollment);
    }

    @Operation(
            summary = "Delete a enrollment",
            description = "Deletes a enrollment by ID"
    )
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable UUID id) {
        enrollmentService.deleteById(id);
    }

}