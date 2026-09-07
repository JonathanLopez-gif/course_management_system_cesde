package co.edu.cesde.cms.infrastructure.repositories;

import co.edu.cesde.cms.infrastructure.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJpaRepository extends JpaRepository<StudentEntity, Long> {

}
