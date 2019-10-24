package core;


import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;

public class MaxOccurenceStringArray {

	public static void main(String[] args) {

	}

	@Test
	public void getBenAsOutputThenOk() {
		String arr[] = { "A", "B", "C", "C","B","B" };

		assertEquals("B", findMaxOccuredString(arr));
	}

	public String findMaxOccuredString(String arr[]) {

		Map<String, Integer> countMap = new HashMap<>();

		for (String i : arr) {
			if (countMap.containsKey(i)) {
				countMap.put(i, countMap.get(i) + 1);
			} else
				countMap.put(i, 1);

		}

		Iterator<Entry<String, Integer>> itr = countMap.entrySet().iterator();

		int maxCount = 0;
		String outputKey = "";
		
		System.out.println(countMap);

		while (itr.hasNext()) {

			Entry<String, Integer> current = itr.next();

			if (current.getValue() > maxCount) {
				maxCount = current.getValue();
				outputKey = current.getKey();
			}

		}

		return outputKey;
	}

}
