package co.edu.cesde.cms.infrastructure.jpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @NotEmpty
    @Column(name = "code", unique = true, nullable = false, length = 100)
    private String code;

    @NotEmpty
    @Column(name = "name")
    private String name;

    @NotEmpty
    @Column(name = "description")
    private String description;

    @NotBlank
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
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
    }

}