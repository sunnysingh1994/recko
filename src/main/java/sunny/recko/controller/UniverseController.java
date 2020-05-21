package sunny.recko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sunny.recko.config.convertor.PersonConvertor;
import sunny.recko.config.convertor.UniverseConvertor;
import sunny.recko.config.dto.UniverseDto;
import sunny.recko.entity.PersonEntity;
import sunny.recko.entity.UniverseEntity;
import sunny.recko.repository.UniverseRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("universe" )
@Api(value = "universe Controller")
public class UniverseController {

    @Autowired
    UniverseRepository universeRepository;

    @ApiOperation(value = "Get all universe")
    @RequestMapping(method = RequestMethod.GET,value = "/all" )
    public List<UniverseDto> getAll() {
        List<UniverseEntity> entities = (List<UniverseEntity>) universeRepository.findAll();
    	return entities.parallelStream()
    			       .map(UniverseConvertor::toDto)
    			       .collect(Collectors.toList());
    }

    @ApiOperation(value = "Delete a universe")
    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public void deleteItem(@PathVariable Long id) {
        universeRepository.deleteById(id);
    }

    @ApiOperation(value = "create a universe")
    @RequestMapping(method = RequestMethod.POST,value = "/create")
    public UniverseDto addItems(@RequestBody UniverseEntity universe){
    	UniverseEntity  entity = universeRepository.save(universe);
    	return UniverseConvertor.toDto(entity);
    }

    @ApiOperation(value = "Get a universe data")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public UniverseDto getById(@PathVariable Long id){
    	Optional<UniverseEntity>  entity = universeRepository.findById(id);
    	return entity.isPresent() ? UniverseConvertor.toDto(entity.get()):null;
    	
    }


}
