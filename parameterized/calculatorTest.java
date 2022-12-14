package parameterized;



import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class calculatorTest {
	private int firstnum,secondnum,result;
	private calculator cal;
	public calculatorTest(int firstnum,int secondnum,int result) {
		super();
		this.firstnum=firstnum;
		this.secondnum=secondnum;
		this.result=result;
	}
	@Before
	public void initialize() {
		cal=new calculator();
	}
	@Parameterized.Parameters
	public static Collection generateData() {
		return Arrays.asList(new Object[][] {{1,2,3},{7,3,10},{2,4,6}});
	}
	@Test
	public void testing() {
		System.out.println("sum of numbers : "+result);
		assertEquals(result, cal.sum(firstnum, secondnum));
	}

}
