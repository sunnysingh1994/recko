package sunny.recko.config.convertor;

import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.UtilityClass;
import sunny.recko.config.dto.FamilyDto;
import sunny.recko.entity.FamilyEntity;

@UtilityClass
public class FamilyConvertor {

    public static FamilyDto toDto(FamilyEntity entity) {
    	return FamilyDto.builder()
    	.id(entity.getId())
    	.name(entity.getName())
    	.familyid(entity.getFamilyid())
    	.universeid(entity.getUniverseid())
    	.build();
    }
    
    public static List<FamilyDto> toDto(List<FamilyEntity> entities) {
    	return entities.parallelStream()
    	        .map(entity -> toDto(entity))
    	        .collect(Collectors.toList());
    }
    
    public static FamilyEntity toEntity(FamilyDto dto) {
    	return FamilyEntity.builder()
    	.id(dto.getId())
    	.name(dto.getName())
    	.familyid(dto.getFamilyid())
    	.universeid(dto.getUniverseid())
    	.build();
    }

}
