package core;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RainWaterHarvestingCountTest {

	@Test
	public void successWhenCountIsSeven() {
		RainWaterHarvestingCount obj = new RainWaterHarvestingCount();
		int[] input = { 0, 0, 0, 2, 0, 0, 1, 3, 0, 2, 0, 0, 0 };
		assertEquals(7, obj.findWaterHarvested(input));
	}
}
