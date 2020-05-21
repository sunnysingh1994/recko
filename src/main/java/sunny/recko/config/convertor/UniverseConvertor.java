package sunny.recko.config.convertor;


import java.util.List;
import java.util.stream.Collectors;

import sunny.recko.config.dto.UniverseDto;
import sunny.recko.entity.UniverseEntity;

public class UniverseConvertor {
    
    public static UniverseDto toDto(UniverseEntity entity) {
    	return UniverseDto.builder()
    	.id(entity.getId())
    	.name(entity.getName())
    	.build();
    }
    
    public static List<UniverseDto> toDto(List<UniverseEntity> entities) {
    	return entities.parallelStream()
    	        .map(entity -> toDto(entity))
    	        .collect(Collectors.toList());
    }
    
    public static UniverseEntity toEntity(UniverseDto dto) {
    	return UniverseEntity.builder()
    	.id(dto.getId())
    	.name(dto.getName())
    	.build();
    }
}
