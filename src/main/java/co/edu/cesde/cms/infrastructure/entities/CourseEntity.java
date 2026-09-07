package co.edu.cesde.cms.infrastructure.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.*;
import java.util.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Long id;

    @NotBlank
    @Column(name = "code", unique = true, nullable = false, length = 100)
    private String code;

    @NotBlank
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    @NotNull
    @Min(value = 15, message = "El mínimo de capacidad del curso debe ser al menos 15")
    @Max(value = 30, message = "El máximo de capacidad del curso debe ser máximo de 30")
    @Column(name = "max_capacity")
    private Integer maxCapacity;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    // Relación Uno a Muchos con Enrollment
    @OneToMany(mappedBy = "course", // Apunta al campo course dentro de EnrollmentEntity
               cascade = CascadeType.ALL, // Al guardar/eliminar un curso, sus enrollments asociadas se procesan autom.
               orphanRemoval = true) // Elimina de la BD cualquier enrollment que sea removida de la lista enrollments
    @ToString.Exclude // Evita un bucle infinito (StackOverflowError) al imprimir el objeto
    private List<EnrollmentEntity> enrollments = new ArrayList<>(); // Evita NullPointerException al agregar elementos sin haber consultado la BD antes

    public CourseEntity(String code, String name, String description, Integer maxCapacity) {
        this.code = code;
        this.name = name;
        this.description = description;
        this.maxCapacity = maxCapacity;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

}