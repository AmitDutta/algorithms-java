import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class BstTest {
	private Bst bst1;
	private Bst bst2;
	@Before
	public void setUp(){
		bst1 = new Bst();
		bst2 = new Bst();
	}	
	@Test
	public void getCommonsWithTest1(){
		bst1.addAll(new int[]{25,20,10,22,50,35,65});
		bst2.addAll(new int[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWith(bst2);
		Integer[] expecteds = new Integer[]{35, 50, 65};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWith(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithTest2(){
		bst1.addAll(new int[]{});
		bst2.addAll(new int[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWith(bst2);
		Integer[] expecteds = new Integer[]{};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWith(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithTest3(){
		bst1.addAll(new int[]{100});
		bst2.addAll(new int[]{100});
		List<Integer> commons =  bst1.getCommonsWith(bst2);
		Integer[] expecteds = new Integer[]{100};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWith(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithIteratorTest1(){
		bst1.addAll(new int[]{25,20,10,22,50,35,65});
		bst2.addAll(new int[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithIterator(bst2);
		Integer[] expecteds = new Integer[]{35, 50, 65};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithIteratorTest2(){
		bst1.addAll(new int[]{});
		bst2.addAll(new int[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithIterator(bst2);
		Integer[] expecteds = new Integer[]{};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithIteratorTest3(){
		bst1.addAll(new int[]{100});
		bst2.addAll(new int[]{100});
		List<Integer> commons =  bst1.getCommonsWithIterator(bst2);
		Integer[] expecteds = new Integer[]{100};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithMorrisIteratorTest1(){
		bst1.addAll(new int[]{25,20,10,22,50,35,65});
		bst2.addAll(new int[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithMorrisIterator(bst2);
		Integer[] expecteds = new Integer[]{35, 50, 65};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithMorrisIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithMorrisIteratorTest2(){
		bst1.addAll(new int[]{});
		bst2.addAll(new int[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithMorrisIterator(bst2);
		Integer[] expecteds = new Integer[]{};;
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithMorrisIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithMorrisIteratorTest3(){
		bst1.addAll(new int[]{100});
		bst2.addAll(new int[]{100});
		List<Integer> commons =  bst1.getCommonsWithMorrisIterator(bst2);
		Integer[] expecteds = new Integer[]{100};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithMorrisIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@After
	public void tearDown(){
		bst1 = null;
		bst2 = null;
	}
}
