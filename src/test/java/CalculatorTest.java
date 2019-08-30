import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testAdd() {
		Calculator obj = new Calculator();
		obj.setA(5);
		obj.setB(3);
		assertEquals(8, obj.add());
	}

	@Test
	public void testSubtract() {
		Calculator obj = new Calculator();
		obj.setA(5);
		obj.setB(3);
		assertEquals(2, obj.subtract());
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
		assertEquals(5, obj.division());
	}

}
