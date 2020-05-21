package sunny.recko.config.convertor;

import java.util.List;
import java.util.stream.Collectors;

import lombok.experimental.UtilityClass;
import sunny.recko.config.dto.FamilyDto;
import sunny.recko.config.dto.PersonDto;
import sunny.recko.entity.FamilyEntity;
import sunny.recko.entity.PersonEntity;

@UtilityClass
public class PersonConvertor  {
      
    public static PersonDto toDto(PersonEntity entity) {
    	return PersonDto.builder()
    	.id(entity.getId())
    	.power(entity.getPower())
    	.familyid(entity.getFamilyid())
    	.universeid(entity.getUniverseid())
    	.build();
    }
    
    public static List<PersonDto> toDto(List<PersonEntity> entities) {
    	return entities.parallelStream()
    	        .map(entity -> toDto(entity))
    	        .collect(Collectors.toList());
    }
    
    public static PersonEntity toEntity(PersonDto dto) {
    	return PersonEntity.builder()
    	.id(dto.getId())
    	.power(dto.getPower())
    	.familyid(dto.getFamilyid())
    	.universeid(dto.getUniverseid())
    	.build();
    }

}
