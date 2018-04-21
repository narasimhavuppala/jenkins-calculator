import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() {
		Calculator obj = new Calculator();
		obj.setA(5);
		obj.setB(3);
		Assert.assertEquals(8, obj.add());
	}

	@Test
	public void testSubtract() {
		Calculator obj = new Calculator();
		obj.setA(5);
		obj.setB(3);
		Assert.assertEquals(2, obj.subtract());
	}

	@Test(expected = Exception.class)
	public void testDivision_zero() {
		Calculator obj = new Calculator();
		obj.setA(5);
		obj.setB(0);
		obj.division();
	}

	@Test
	public void testDivision_NoZero() {
		Calculator obj = new Calculator();
		obj.setA(5);
		obj.setB(1);
		Assert.assertEquals(4, obj.division());
	}

}
