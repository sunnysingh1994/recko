package sunny.recko.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import sunny.recko.config.convertor.FamilyConvertor;
import sunny.recko.config.dto.FamilyDto;
import sunny.recko.entity.FamilyEntity;
import sunny.recko.repository.FamilyRepository;
import sunny.recko.repository.UniverseRepository;
import sunny.recko.service.Balance;

@RestController
@RequestMapping("family" )
@Api(value = "Answer controller")
public class AnswerController {
	
	 @Autowired
	 FamilyRepository familyRepository;
	    
	 @Autowired
	 UniverseRepository universeRepository;
	    
	 @Autowired
	 Balance balance;
	
	 @ApiOperation(value = "1. List families in a particular universe")
	    @RequestMapping(method = RequestMethod.GET,value = "/universe/{id}")
	    public List<FamilyDto> getByUniverseId(@PathVariable("id") Long universeid){
	    	List<FamilyEntity> entities = familyRepository.findByUniverseid(universeid);
	    	return FamilyConvertor.toDto(entities);
	   }
	 
	  @ApiOperation(value = "2. check if a given family is balance are not")
	    @RequestMapping(method = RequestMethod.GET,value = "/balance/{id}")
	    public boolean getByfamilyId(@PathVariable Long id){
	        return balance.isBalance(id);
	    }
	  
	  @ApiOperation(value = "3. Find unbalanced family_ids")
	    @RequestMapping(method = RequestMethod.GET,value = "/unbalance")
	    public Set<Long> getAllUnBlalanceFamilies(){
	        List<FamilyEntity> families = (List<FamilyEntity>) familyRepository.findAll();
	        Set<Long> set = new HashSet<>();
	        for(FamilyEntity f : families){
	            if(!balance.isBalance(f.getFamilyid())){
	                set.add(f.getFamilyid());
	            }

	        }
	       return set;
	    }
	  
	  
	  @ApiOperation(value = "4. Balance given family_id")
	  @RequestMapping(method = RequestMethod.GET,value = "/balance/family/{id}")
	    public void balanceGivenFamily(@PathVariable Long id){
		  balance.balanceGivenFamily(id);
	    }

}
