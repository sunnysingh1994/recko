package sunny.recko.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sunny.recko.entity.UniverseEntity;

public interface UniverseRepository extends JpaRepository<UniverseEntity,Long> {
}
