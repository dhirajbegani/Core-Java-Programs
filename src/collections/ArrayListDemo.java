package collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> stringList = new ArrayList<>();

		stringList.add("Derik");
		stringList.add("Kane");
		stringList.add("Vector");

		// Iterate using forEach
		stringList.forEach(a -> {
			a = "Name is " + a;
			System.out.println(a);
		});

		// Iterate using iterator
		Iterator<String> itr = stringList.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		SamplePredicate<String> filter = new SamplePredicate<String>();

		stringList.removeIf(filter);

		System.out.println("Array lsit after removing all elements that contains \"K\" " );
		System.out.println(stringList);

		// Add duplicates in Arraylist.
		stringList.add("Kane");
		stringList.add("Derik");
		stringList.add("Vector");

		System.out.println("Array List with duplicates "); 
		System.out.println(stringList);

		
		Set <String> stringListWithoutDuplicates = new LinkedHashSet<String>(stringList);
		
		//Remove all elements from array list
		stringList.clear();
		
		stringList.addAll(stringListWithoutDuplicates);
		System.out.println("Array List without duplicates (Ordering guranteed as LinkedHashSet is used)");
		System.out.println(stringList);
		
		Collection<String> newUnmodifiableList = Collections.unmodifiableCollection(stringList);
		
		try {
		newUnmodifiableList.add("Any Name");
		} catch(UnsupportedOperationException e) {
		System.out.println("Add operation not allowed");
		}
		
		System.out.println(newUnmodifiableList);
	}

}

class SamplePredicate<T> implements Predicate<T> {

	public boolean test(T t) {

		if (t.toString().contains("K")) {

			return true;
		}
		return false;
	}

}