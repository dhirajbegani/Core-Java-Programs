package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ArrayListDemo {	

	List<String> stringList = new ArrayList<>();

	private void iterateUsingForEach(List<String> list) {

		// Iterate using forEach
		list.forEach(a -> {
			a = "Name is " + a;
			System.out.println(a);
		});

	}

	private static void addThreeElements(ArrayListDemo obj) {
		obj.stringList.add("Derik");
		obj.stringList.add("Kane");
		obj.stringList.add("Vector");
	}

	private void iterateUsingIterator(List<String> list) {

		// Iterate using iterator
		Iterator<String> itr = stringList.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayListDemo obj = new ArrayListDemo();
		addThreeElements(obj);

		obj.iterateUsingForEach(obj.stringList);
		obj.iterateUsingIterator(obj.stringList);

		obj.stringList.removeIf(a -> a.toString().contains("K"));

		System.out.println("Array lsit after removing all elements that contains \"K\" ");
		System.out.println(obj.stringList);

		// Add duplicates in Arraylist.
		addThreeElements(obj);

		System.out.println("Array List with duplicates ");
		System.out.println(obj.stringList);

		Set<String> stringListWithoutDuplicates = new LinkedHashSet<>(obj.stringList);
		
		System.out.println("Array List without duplicates (Ordering guranteed as LinkedHashSet is used)");
		System.out.println(stringListWithoutDuplicates);

		Collection<String> newUnmodifiableList = Collections.unmodifiableCollection(obj.stringList);

		try {
			newUnmodifiableList.add("Any Name");
		} catch (UnsupportedOperationException e) {
			System.out.println("Add operation not allowed");
		}

	}

}