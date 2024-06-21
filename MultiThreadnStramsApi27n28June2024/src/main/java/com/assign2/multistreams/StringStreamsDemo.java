package com.assign2.multistreams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringStreamsDemo {

	public static void main(String[] args) {
		
		List<String> strlist=new ArrayList<String>();
		strlist.add("sachin");
		strlist.add("ganguly");
		strlist.add("ragu");
		strlist.add("arjunan");
		strlist.add("amritha");
		strlist.add("amit");
		
		Map<Boolean, List<String>> list=strlist.stream()
								.collect(Collectors.partitioningBy(e->e.length()<5));
		//list.forEach((k,v)->System.out.println(k+" ==> "+v));
			for(Map.Entry<Boolean, List<String>> mapp:list.entrySet()) {
				
				if(mapp.getKey().equals(true)) {
					System.out.println(mapp.getValue().toString().toUpperCase().replaceAll("[,]", "").replaceAll(" ", "").concat(","));
				}else {
					System.out.println(mapp.getValue());
				}
			}
	}
}
