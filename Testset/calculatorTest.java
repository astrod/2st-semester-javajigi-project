import org.junit.Assert;


public class CalculatorTest extends junit.framework.TestCase{
	private String_calculator_Junit cal;
	
	protected void setUp() throws Exception {
		 cal = new String_calculator_Junit();		
	}
	
	public void testCutWhenComma() {
		String [] stringArray = cal.cut("1");
		Assert.assertArrayEquals(new String[]{"1"}, stringArray);	
		stringArray = cal.cut("");
		Assert.assertArrayEquals(new String[]{""}, stringArray);	
	}

	public void testToInt() throws Exception {
		int [] result = cal.toInt(new String[]{"1", "2"});
		Assert.assertArrayEquals(new int[]{1, 2}, result);
	}
	
	public void testCreate(){
		
		
	}
}
