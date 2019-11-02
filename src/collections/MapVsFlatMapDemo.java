package collections;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;

public class MapVsFlatMapDemo {

	@Test
	public void testMap() {

		List<String> stringList = new ArrayList<>();
		stringList.add("Apple");
		stringList.add("Orange");
		stringList.add("Banana");
		stringList.add("Kiwi");
		stringList.add("Water Melon");
		List<Integer> listOfInteger = getListOfIntFromStringListUsingMap(stringList);
		System.out.println(listOfInteger);
		assertEquals(5, listOfInteger.size());
	}

	@Test
	public void testFlatMap() {

		List<List<Integer>> listOfIntegerList = new ArrayList<>();
		listOfIntegerList.add(Arrays.asList(5, 6));
		listOfIntegerList.add(Arrays.asList(1, 2));
		listOfIntegerList.add(Arrays.asList(3, 4));
		listOfIntegerList.add(Arrays.asList(7, 8));

		List<Integer> listOfInteger = getListOfIntFromListOfListUsingFlatMap(listOfIntegerList);
		System.out.println(listOfInteger);
		assertEquals(8, listOfInteger.size());
	}

	private List<Integer> getListOfIntFromStringListUsingMap(List<String> stringList) {

		List<Integer> listOfInteger = stringList.stream().map(a -> a.length()).collect(Collectors.toList());
		return listOfInteger;
	}

	private List<Integer> getListOfIntFromListOfListUsingFlatMap(List<List<Integer>> listOfIntegerList) {

		List<Integer> listOfInteger = listOfIntegerList.stream().flatMap(a -> a.stream()).collect(Collectors.toList());
		return listOfInteger;
	}

}
