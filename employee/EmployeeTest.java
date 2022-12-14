package com.employee;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	Object[] objarr = new Object[5];

	@Before
	public void InItInputs() {
		objarr[0] = (new Employee("pritam", 101, 20000));
		objarr[1] = (new Employee("Akash", 102, 10000));
		objarr[2] = (new Employee("subrato", 103, 30000));
		objarr[3] = (new Employee("Arnab", 104, 60000));
		objarr[4] = (new Employee("Dev", 105, 50000));
	}

	@Test
	public void compare() {
		// we want to convert the list of objects to array of objects
		Object[] objarr2 = Employee.getEmpList().toArray();
		assertArrayEquals(objarr, objarr2);
	}

}
