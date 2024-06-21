package com.assign2.multistreams.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentDemo {

	public static void main(String[] args) {
		
		List<Student> listOfStud=new ArrayList<Student>();
		listOfStud.add(new Student("Elumalai",23,"A"));
		listOfStud.add(new Student("Amritha",13,"B"));
		listOfStud.add(new Student("Deeba",24,"A"));
		listOfStud.add(new Student("Raja",12,"B"));
		listOfStud.add(new Student("Adithya",15,"B"));
		listOfStud.add(new Student("Kumar",17,"A"));

		Map<Boolean, List<Student>> mapList = listOfStud.stream()
				.sorted((s1,s2)->s1.getGrade().compareTo(s2.getGrade()))
				.collect(Collectors.partitioningBy(e->e.getAge()<18));
		//mapList.forEach((k,v)->System.out.println(k+" ==> "+v));
		List<Student> list=null;
		for(Map.Entry<Boolean, List<Student>> sortMap: mapList.entrySet()) {
			
			if(sortMap.getKey().equals(true)) {
				
				list = new ArrayList<Student>(sortMap.getValue());
				
			}
			
			boolean retVal = Optional.ofNullable(list).filter(l -> !l.isEmpty()).isPresent();
			if(retVal) {
				for(Student st: list) {
					System.out.println(st.getName()+"  "+st.getGrade());
				}
			}
			
		
		}

	}
}
