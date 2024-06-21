package com.assign2.multistreams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EvenOddIntegerDemo {
	
	public static void evenOddNumbers(List<Integer> nums) {
		
		
		  Map<Boolean, List<Integer>> oddEven = nums.stream()
		  .collect(Collectors.partitioningBy(n -> n % 2 == 0));
		 
		  oddEven.forEach((k,v)->System.out.println(k+" ==>\n"+v.stream()
          .distinct()
          .map(n -> n+"\t"+n*n) 
          .collect(Collectors.joining("\n")) ));
		  
		
		
	}
	
	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1,2,3,4,5);	
		evenOddNumbers(nums);
	}
}
