package sunny.recko.repository;

import org.springframework.data.repository.CrudRepository;

import sunny.recko.entity.PersonEntity;

import java.util.List;

public interface PersonRepository extends CrudRepository<PersonEntity,Long> {

    List<PersonEntity> findByFamilyid(Long id);
}
