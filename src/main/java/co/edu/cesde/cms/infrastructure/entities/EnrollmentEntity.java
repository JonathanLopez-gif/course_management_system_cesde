package co.edu.cesde.cms.infrastructure.entities;

import co.edu.cesde.cms.domain.models.EnrollmentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "enrollment_id")
    private UUID id;

    // Relación Muchos a Uno
    // Establece que muchas matrículas pertenecen a un estudiante/curso
    // Carga la relación solo cuando se necesita para optimizar rendimiento
    @ManyToOne(fetch = FetchType.LAZY)
    // Define el nombre exacto de la columna clave foránea en la BD
    @JoinColumn(name = "student_id", nullable = false)
    private StudentEntity student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",  nullable = false)
    private CourseEntity course;

    @Enumerated(EnumType.STRING) // Guarda el nombre del enum en la BD
    @Column(name = "enrollment_status", nullable = false, length = 20)
    private EnrollmentStatus status;

    @Column(name = "enrollment_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "enrollment_updated_at", nullable = false)
    private LocalDateTime updatedAt;

    public EnrollmentEntity(StudentEntity student, CourseEntity course) {
        this.student = student;
        this.course = course;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (status == null) {
            status = EnrollmentStatus.ACTIVE;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}