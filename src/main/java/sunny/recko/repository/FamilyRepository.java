package sunny.recko.repository;

import org.springframework.data.repository.CrudRepository;

import sunny.recko.entity.FamilyEntity;

import java.util.List;

    public interface FamilyRepository extends CrudRepository<FamilyEntity,Long> {

        List<FamilyEntity> findByUniverseid(Long id);
}
