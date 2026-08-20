package co.edu.cesde.cms.infrastructure.jpa.entities;

import co.edu.cesde.cms.domain.models.EnrollmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class StudentEntity {

    @Id
    @Column(name = "student_id")
    private Long id;

    @NotEmpty
    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Email
    @Column(name = "email", unique = true, nullable = false, length = 150)
    private String email;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "enrollment_status")
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
        this.enrollmentStatus = EnrollmentStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}