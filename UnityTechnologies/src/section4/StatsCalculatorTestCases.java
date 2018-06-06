package section4;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StatsCalculatorTestCases {
	private StatsCollector statsCalculator;

	@Before
	public void setUp() {
		statsCalculator = new StatsCollector();
	}

	@Test
	public void test() {
		//without any requests
		assertEquals("-1.0", Double.toString(statsCalculator.getAverage()));
		assertEquals("-1.0", Double.toString(statsCalculator.getMedian()));
		
		statsCalculator.pushValue(0);
		//0
		assertEquals("0.0", Double.toString(statsCalculator.getAverage()));
		assertEquals("0.0", Double.toString(statsCalculator.getMedian()));
		
		statsCalculator.pushValue(3);
		//0 3
		assertEquals(1, statsCalculator.getAverage());
		assertEquals("1.5", Double.toString(statsCalculator.getMedian()));
		
		statsCalculator.pushValue(3);
		statsCalculator.pushValue(3);
		//0 3 3 3
		assertEquals("2.0", Double.toString(statsCalculator.getAverage()));
		assertEquals("3.0", Double.toString(statsCalculator.getMedian()));
		
		statsCalculator.pushValue(1);
		statsCalculator.pushValue(2);
		statsCalculator.pushValue(2);
		//0 1 2 2 3 3 3
		assertEquals("2.0", Double.toString(statsCalculator.getAverage()));
		assertEquals("2.0", Double.toString(statsCalculator.getMedian()));
		
		statsCalculator.pushValue(2);
		//0 1 2 2 2 3 3 3
		assertEquals("2.0", Double.toString(statsCalculator.getAverage()));
		assertEquals("2.0", Double.toString(statsCalculator.getMedian()));
	}
}
