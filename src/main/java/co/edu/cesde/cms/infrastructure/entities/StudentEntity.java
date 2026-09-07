package co.edu.cesde.cms.infrastructure.entities;

import co.edu.cesde.cms.domain.models.EnrollmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentEntity {

    @Id
    @Column(name = "student_id", nullable = false)
    private Long id;

    @NotBlank
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @NotBlank
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @NotBlank
    @Email
    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "enrollment_status", nullable = false, length = 20)
    private EnrollmentStatus enrollmentStatus;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Relación Uno a Muchos con Enrollment
    @OneToMany(mappedBy = "student", // Apunta al campo student dentro de EnrollmentEntity
               cascade = CascadeType.ALL, // Al guardar/eliminar un estudiante, sus enrollments asociadas se procesan autom.
               orphanRemoval = true) // Elimina de la BD cualquier enrollment que sea removida de la lista enrollments
    @ToString.Exclude // Evita un bucle infinito (StackOverflowError) al imprimir el objeto
    private List<EnrollmentEntity> enrollments = new ArrayList<>(); // Evita NullPointerException al agregar elementos sin haber consultado la BD antes

    public StudentEntity(Long id, String firstName, String lastName, String email, LocalDate birthDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.birthDate = birthDate;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (enrollmentStatus == null) {
            enrollmentStatus = EnrollmentStatus.ACTIVE;
        }
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}