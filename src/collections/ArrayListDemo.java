package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;



public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> stringList = new ArrayList<>();
		
		stringList.add("Derik");		
		stringList.add("Kane");		
		stringList.add("Vector");
		
		//Iterate using forEach
		stringList.forEach(a -> {
			a="Name is " + a;
			System.out.println(a);});
		
		//Iterate using iterator
		Iterator<String> itr = stringList.iterator();
		
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		SamplePredicate<String> filter = new SamplePredicate<String>();
		
		stringList.removeIf(filter);
		
		//Iterate using forEach
				stringList.forEach(a -> {
					a="Name is " + a;
					System.out.println(a);});
				
	}

	
}

class SamplePredicate<T> implements Predicate<T>{
	
	public boolean test(T t) {
		
		if(t.toString().contains("K")) {
		
		return true;
		}
		return false;
	}
	
}