package com.Demo.Test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.Demo.main.Junit_Demo1;

public class Junit_Test1 {
	@Test
	public void max() {
		assertEquals(8, Junit_Demo1.max(new int[] { 1, 2, 4, 6, 8 }));
		assertEquals(-1, Junit_Demo1.max(new int[] { -1, -2, 4, 6, -8 }));
	}

}
