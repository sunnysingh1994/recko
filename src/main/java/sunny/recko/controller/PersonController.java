package sunny.recko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sunny.recko.config.convertor.PersonConvertor;
import sunny.recko.config.dto.PersonDto;
import sunny.recko.entity.FamilyEntity;
import sunny.recko.entity.PersonEntity;
import sunny.recko.repository.FamilyRepository;
import sunny.recko.repository.PersonRepository;
import sunny.recko.repository.UniverseRepository;
import sunny.recko.service.Balance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
@RestController
@RequestMapping("person")
@Api(value = "Person Controller")
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    
    @Autowired
    Balance balance;
    
    @Autowired
    FamilyRepository familyRepository;
    
    @Autowired
    UniverseRepository universeRepository;
    
    @ApiOperation(value = "Get all Persons")
    @RequestMapping(method = RequestMethod.GET,value = "/all" )
    public List<PersonDto> getAll() {
    	List<PersonEntity> entities = (List<PersonEntity>) personRepository.findAll();
    	return entities.parallelStream()
    			       .map(PersonConvertor::toDto)
    			       .collect(Collectors.toList());
    }

    @ApiOperation(value = "Delete a Person")
    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public void deleteItem(@PathVariable Long id) {
        personRepository.deleteById(id);
    }

    @ApiOperation(value = "Create a  new Person")
    @RequestMapping(method = RequestMethod.POST,value = "/create")
    public PersonDto addItems(@RequestBody PersonDto person) throws Exception{
    	if(!universeRepository.existsById(person.getUniverseid())) {
    		throw new Exception("Universe Does not exits for this univers id" + person.getUniverseid());
    	}
    	
    	if(!familyRepository.existsById(person.getFamilyid())) {
    		throw new Exception("Family Does not exits for this family id" + person.getFamilyid());
    	}
    	PersonEntity entity = personRepository.save(PersonConvertor.toEntity(person));
    	return PersonConvertor.toDto(entity);
    }

    @ApiOperation(value = "Get a person detail")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public PersonDto getById(@PathVariable Long id){
    	Optional<PersonEntity> entity = personRepository.findById(id);
    	return entity.isPresent() ? PersonConvertor.toDto(entity.get()) : null; 
    }

  
}

