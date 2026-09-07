package co.edu.cesde.cms.infrastructure.repositories;

import co.edu.cesde.cms.infrastructure.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJpaRepository extends JpaRepository<CourseEntity, Long> {

}
