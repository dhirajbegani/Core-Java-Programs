package stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams { 
	
	public static void main(String [] args) throws IOException {

		//1. Integer Stream		
		System.out.println("1. Interger Stream Range");
		IntStream
		   .range(1, 10)
		   .forEach(System.out :: println);

		//2. Integer Stream
		System.out.println("2. Interger Stream Range Skip and Sum");
		System.out.println(IntStream
		   .range(1, 10)
		   .skip(4)
		   .sum());
		
		//3. Stream.of
		System.out.println("3. Stream.of sorted & findFirst");
		
		Stream.of("Kavita","Viraj", "Dhiraj")
		 .sorted()
		 .findFirst()
		 .ifPresent(System.out:: println);
		
		//4. Stream from Array and filter data
		System.out.println("4. Stream from Array and filter data");
		
		String[] names = {"Kavita","Dhiraj","Viraj","Veer"};
		
		Arrays.stream(names)
		   .filter(x -> x.startsWith("V"))
		   .sorted()
		   .forEach(System.out :: println);
		
		//5. Average of squares of an Integer Array
		System.out.println("5. Average of squares of an Integer Array");
		
		Arrays.stream(new int[] {2,4,6,8,10})
		      .map(x-> x*x)
		      .average()
		      .ifPresent(System.out:: println);
		
		//6. Stream from List, Filter and print 
		System.out.println("6. Stream from List, Filter and print");
		
		List <String> people = Arrays.asList("Dhiraj","Kavita","Veer","Viraj","NoOne","SomeOne");
		
		people.stream()
		      .map(String::toUpperCase)
		      .filter(x -> x.startsWith("V"))
		      .forEach(System.out::println);
		
		//7. Stream rows from text file, sort, filter and print
		System.out.println("7. Stream rows from text file, sort, filter and print");
		
		Stream <String> peopleNames = Files.lines(Paths.get("people.txt"));
		
		peopleNames.sorted()
		           .filter(x-> x.startsWith("V") || x.startsWith("B"))
		           .forEach(System.out :: println);
		
		peopleNames.close();

		//8. Stream rows from text file and save to another list
		System.out.println("8. Stream rows from text file and save to another list");
		
		List <String> peopleNames2 = Files.lines(Paths.get("people.txt"))
				                          .filter(x-> x.startsWith("V") || x.startsWith("B"))
				                          .collect(Collectors.toList());
		
		peopleNames2.forEach(System.out :: println);
		
		//9. Read rows from CSV file and filter empty or bad data
		System.out.println("9. Read rows from CSV file and filter empty or bad data");
				
		Stream <String> rows = Files.lines(Paths.get("data.csv"));
		
		int goodRows = (int) rows.map(x -> x.split(","))
				                 .filter(x -> x.length ==3)
				                 .count();
        System.out.println("There are total " + goodRows + " good rows.");
        rows.close();
        
        }
				
}
