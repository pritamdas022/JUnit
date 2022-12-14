package PrimeNumber;

import static org.junit.Assert.assertEquals;

import java.util.Scanner;

import org.junit.Test;

public class PrimeNumberTest {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	static PrimeEg pmEg;

	@Test
	public void Test1() {
		pmEg = new PrimeEg();
		assertEquals(false, pmEg.isPrime(num));
	}

}
