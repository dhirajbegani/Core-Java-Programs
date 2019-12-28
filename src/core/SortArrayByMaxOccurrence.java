package core;

public class SortArrayByMaxOccurrence {

	public static int x = 0;

	public static void main(String[] args) {

		int inputArray[] = { 1, 3, 4, 6, 4, 3, 6, 4 };
		SortArrayByMaxOccurrence obj = new SortArrayByMaxOccurrence();

		System.out.println("Input is:");
		for (int i : inputArray) {
			System.out.print(i + " ");
		}
		
		inputArray = obj.processInput(inputArray);

		System.out.println("\nOutput is:");
		for (int i : inputArray) {
			System.out.print(i + " ");
		}

	}

	private int[] processInput(int[] inputArray) {
		inputArray = sortIntArray(inputArray);
		// {1,3,3,4,4,4,6,6}

		int occurenceArray[][] = new int[inputArray.length][2];

		occurenceArray[0][0] = inputArray[0];
		occurenceArray[0][1] = 1;

		for (int i = 0; i < inputArray.length - 1; i++) {
			if (inputArray[i] == inputArray[i + 1]) {
				occurenceArray[x][1] = occurenceArray[x][1] + 1;
			} else {
				++x;
				occurenceArray[x][0] = inputArray[i + 1];
				occurenceArray[x][1] = 1;

			}
		}

		int occurenceArrayNew[][] = new int[x + 1][2];

		for (int i = 0; i < x + 1; i++) {
			occurenceArrayNew[i] = occurenceArray[i];
		}

		occurenceArrayNew = sortIntArray(occurenceArrayNew);

		int y = 0;

		for (int i = 0; i < occurenceArrayNew.length; i++) {
			for (int j = 0; j < occurenceArrayNew[i][1]; j++) {
				inputArray[y++] = occurenceArrayNew[i][0];
			}
		}
		return inputArray;
	}

	public int[][] sortIntArray(int input[][]) {
		int a[] = new int[1];
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[i][1] > input[j][1]) {
					a = input[i];
					input[i] = input[j];
					input[j] = a;
				}
			}
		}
		return input;
	}

	public int[] sortIntArray(int input[]) {
		int a;
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input.length; j++) {
				if (input[j] > input[i]) {
					a = input[i];
					input[i] = input[j];
					input[j] = a;
				}
			}
		}
		return input;
	}

}
