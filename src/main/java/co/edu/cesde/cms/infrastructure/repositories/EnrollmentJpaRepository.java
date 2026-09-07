package co.edu.cesde.cms.infrastructure.repositories;

import co.edu.cesde.cms.infrastructure.entities.EnrollmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EnrollmentJpaRepository extends JpaRepository<EnrollmentEntity, UUID> {

}
