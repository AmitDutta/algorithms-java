import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BitDivideTest {
	private BitDivide bitDivide;
	@Before
	public void setup(){
		bitDivide = new BitDivide(45, 8);
	}
	@Test
	public void existsBitDivideTest(){		
		bitDivide.put(23);
		bitDivide.put(0);
		bitDivide.put(5);
		bitDivide.put(21);
		assertTrue(bitDivide.exists(23));
		assertTrue(bitDivide.exists(0));
		assertTrue(bitDivide.exists(5));
		assertTrue(bitDivide.exists(21));		
	}
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void outofboundTest(){
		bitDivide.put(1000);
		bitDivide.put(1000);
	}
	@Test
	public void notExistsTest(){
		assertFalse(bitDivide.exists(15));
		assertFalse(bitDivide.exists(16));
	}
	@After
	public void teardown(){
		bitDivide = null;
	}
}
