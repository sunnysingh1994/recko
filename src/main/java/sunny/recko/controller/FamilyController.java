package sunny.recko.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sunny.recko.config.convertor.FamilyConvertor;
import sunny.recko.config.dto.FamilyDto;
import sunny.recko.entity.FamilyEntity;
import sunny.recko.repository.FamilyRepository;
import sunny.recko.repository.UniverseRepository;
import sunny.recko.service.Balance;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("family" )
@Api(value = "Family Controller")
public class FamilyController {
    @Autowired
    FamilyRepository familyRepository;
    
    @Autowired
    UniverseRepository universeRepository;
    
    @Autowired
    Balance balance;
    
    
    @ApiOperation(value = "Get all Family")
    @RequestMapping(method = RequestMethod.GET,value = "/all")
    public List<FamilyDto> getAll() {
         List<FamilyEntity> entities = (List<FamilyEntity>) familyRepository.findAll();
         return FamilyConvertor.toDto(entities);
    }

    @ApiOperation(value = "Delete a family by giving familiy Id")
    @RequestMapping(method = RequestMethod.DELETE,value = "/{id}")
    public void deleteItem(@PathVariable Long id) {
        familyRepository.deleteById(id);
    }

    @ApiOperation(value = "Create a new family")
    @RequestMapping(method = RequestMethod.POST,value = "/create")
    public FamilyDto addItems(@RequestBody FamilyDto family) throws Exception{
    	if(!universeRepository.existsById(family.getUniverseid())) {
    		throw new Exception("Universe Does not exits for this univers id" + + family.getUniverseid());
    	}
    	FamilyEntity familyEntity = familyRepository.save(FamilyConvertor.toEntity(family));
    	return FamilyConvertor.toDto(familyEntity);
    }

    
    @ApiOperation(value = "Get family deletail by id")
    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public FamilyDto getById(@PathVariable Long id){
    	Optional<FamilyEntity> familyEntity = familyRepository.findById(id);
    	return familyEntity.isPresent() ? FamilyConvertor.toDto(familyEntity.get()): null;
    }

   
    
  





}
