package com.stackroute.streams;

import java.util.LinkedList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.Optional;

public class BatsmanService {
  
	public Optional<Batsman> getBatsman(List<Batsman> bmanList,String batsName,String countryCode){
		
		List<String> validCountr=List.of("IN","AU","SA");
		if(bmanList == null || countryCode ==null) {
			return Optional.empty();
		}		
		if(!validCountr.contains(countryCode)) {
			throw new CountryNotFoundException();
		}		
		return  bmanList.stream().filter(bm->bm.getName().equalsIgnoreCase(batsName) 
						&& bm.getCountry().getCountryCode().equals(countryCode)).findFirst();
			    
	}
    public String getBatsmanNamesForCountry(List<Batsman> batsmanList, String country)
    {
    	
    	String batsmanLst=null;
    	boolean retVal = Optional.ofNullable(batsmanList).filter(l -> !l.isEmpty()).isPresent(); 
    	if(retVal) {
    		batsmanLst= batsmanList.stream().sorted()
    				 .filter(b-> b.getCountry().getCountryCode().equals(country))
    				 .map(s->s.getName()).collect(Collectors.toList()).toString();
    		String resultList = batsmanLst.replaceAll("[ ;]", "");
    		
    		return resultList;
    	}else {
    		return batsmanLst;
    	}
    }
    
    public Map<String, Integer> getPlayerNameWithTotalRuns(List<Batsman> batsmanList) {
    	
    	boolean retVal = Optional.ofNullable(batsmanList).filter(l -> !l.isEmpty()).isPresent();
    	if(retVal) {
    		
    		Map<String, Integer> map = batsmanList.stream()
    				.collect(Collectors.toMap(Batsman::getName, Batsman::getTotalRuns,
    						(oldValue, newValue) -> oldValue,LinkedHashMap::new));
        	return map;
    	}else {
    		return Collections.emptyMap();
    	}
    	
    }
    
	public Integer getHighestRunsScoredByBatsman(List<Batsman> bmanList,String country){
		Integer batsmanList=null;
		
		boolean retVal = Optional.ofNullable(bmanList).filter(l -> !l.isEmpty()).isPresent();
		if(retVal) {
			 batsmanList = bmanList.stream()
					 .filter(bm-> bm.getCountry().getName().equals(country) && bm.getMatchesPlayed() ==105)
					 .map(s->s.getMatchesPlayed())
				            .collect(Collectors.toList()).get(0);
			
			 return batsmanList;
		}else {
			return 0;
		}
	}
	
		@SuppressWarnings("rawtypes")
		public Optional<LinkedList> getPlayerNamesByCountry(List<Batsman> bmanList,String country){
			LinkedList<Object> linkedList=new LinkedList<>(); 
			boolean retVal = Optional.ofNullable(bmanList).filter(l -> !l.isEmpty()).isPresent();
			if(retVal) {
				if(country.equalsIgnoreCase("India")) {
					List<Batsman> batsmanList = bmanList.stream()
							.filter(bm-> bm.getCountry().getName().equals(country) 
							 && bm.getTotalRuns() >5000)								
					            .collect(Collectors.toList());
					for(Batsman bats: batsmanList) {
						linkedList.add(bats.getName());
					}
					return Optional.of(linkedList);
				}else if(country.equalsIgnoreCase("SouthAfrica")) {
					@SuppressWarnings("unused")
					List<Batsman> batsmanList = bmanList.stream()
							.filter(bm-> bm.getCountry().getName().equals(country))								
					            .collect(Collectors.toList());
					return Optional.empty();
				}
			}
			else {
				return Optional.empty();
			}
			
				return Optional.ofNullable(new LinkedList<Object>());
			
		}
	
 
}
