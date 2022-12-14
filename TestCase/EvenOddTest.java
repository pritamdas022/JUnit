package TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvenOddTest {
	static EvenOdd eOdd;

	@Test
	public void Test1() {
		eOdd = new EvenOdd();
		int n = 60;
		assertEquals("even", eOdd.Even(n));
	}

	@Test
	public void Test2() {
		eOdd = new EvenOdd();
		int n = 30;
		assertEquals("even", eOdd.Even(n));
	}

}
