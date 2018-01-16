import org.junit.Test;

import junit.framework.Assert;

public class CalculatorTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testAdd() {
		Calculator obj=new Calculator();
		obj.setA(5);
		obj.setB(3);
		Assert.assertEquals(8, obj.add());
	}
	
	@Test
	public void testSubtract() {
		Calculator obj=new Calculator();
		obj.setA(5);
		obj.setB(3);
		Assert.assertEquals(4, obj.subtract());
	}

}
