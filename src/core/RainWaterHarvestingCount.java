package core;

public class RainWaterHarvestingCount {

	public int findWaterHarvested(int[] inputBlocks) {

		int inputLength = inputBlocks.length;
		int leftMax[] = new int[inputLength];
		int rightMax[] = new int[inputLength];
		int currentHighLeft = 0;
		int currentHighRight = 0;
		inputLength -= 1;

		for (int i = 0; i < inputBlocks.length; i++) {

			if (inputBlocks[i] > currentHighLeft) {
				currentHighLeft = inputBlocks[i];
			}
			if (inputBlocks[inputLength - i] > currentHighRight) {
				currentHighRight = inputBlocks[inputLength - i];
			}

			leftMax[i] = currentHighLeft;
			rightMax[inputLength - i] = currentHighRight;
		}

		int waterHarvested = 0;
		for (int i = 0; i < inputBlocks.length; i++) {
			waterHarvested += Math.min(leftMax[i], rightMax[i]) - inputBlocks[i];
		}
		return waterHarvested;
	}
}
