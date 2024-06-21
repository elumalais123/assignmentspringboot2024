package com.assign2.multistreams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReadWordsDemo {

	public static void main(String[] args) throws IOException {

		String path = "C://Users//710922//Documents//Userdata//sample.txt";

		
		List<String> wordList = Files.lines(Paths.get(path)).flatMap(line -> Stream.of(line.split(" ")))
				.collect(Collectors.toList());
		Map<Boolean, List<String>> list = wordList.stream().collect(Collectors.partitioningBy(e -> e.startsWith("A")));
		List<String> listA = list.get(true);
		//List<String> listNotA = list.get(false);
		
		listA.stream().collect(Collectors.toMap(w -> w, x -> 1L, Long::sum, TreeMap::new))
	       .entrySet().stream()
	       .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
	       .forEach(System.out::println);
	}

}
