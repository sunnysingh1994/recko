package sunny.recko.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sunny.recko.entity.PersonEntity;
import sunny.recko.repository.PersonRepository;
import sunny.recko.service.Balance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.OptionalInt;
import java.util.stream.Collectors;
@Service
public class BalanceImpl implements Balance {

  @Autowired
    PersonRepository personRepository;
    @Override
    public boolean isBalance(Long id) {
        List<PersonEntity> persons = personRepository.findByFamilyid(id);
        Map<Long,Integer> map = new HashMap<>();
        for(PersonEntity person: persons){
            if(map.containsKey(person.getUniverseid())){
                int power = map.get(person.getUniverseid());
                power = power + person.getPower();
                map.put(person.getUniverseid(),power);
            }else{
                map.put(person.getUniverseid(),person.getPower());
            }
        }
        boolean balance = true;
        if(map.isEmpty()){
            return balance;
        }
        Integer power = null;
        for(Long uId : map.keySet()){
            if(power==null){
                power = map.get(uId);
            }else if(power!=map.get(uId)){
                return false;
            }
        }
        return true;
    }
	@Override
	public void balanceGivenFamily(Long id) {
		 List<PersonEntity> persons = personRepository.findByFamilyid(id);
         Map<Long,Integer> map = new HashMap<>();
         for(PersonEntity person: persons){
            if(map.containsKey(person.getUniverseid())){
                int power = map.get(person.getUniverseid());
                power = power + person.getPower();
                map.put(person.getUniverseid(),power);
            }else{
                map.put(person.getUniverseid(),person.getPower());
            }
         }
         
         Map<Long,List<PersonEntity>> universPersonMap =   persons.parallelStream()
        		                                           .collect(Collectors.groupingBy(PersonEntity::getUniverseid));
         
         OptionalInt minPower = map.values().stream().mapToInt( v->v).min();
         int min = minPower.getAsInt();
         
         for(Long univereId : map.keySet()) {	
        	 PersonEntity entity = universPersonMap.get(univereId).get(0);
        	 int power = entity.getPower() - (map.get(univereId) - min);
        	 entity.setPower(power);
        	 personRepository.save(entity);
         }
	}
}
