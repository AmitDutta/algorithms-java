import org.junit.*;

import static org.junit.Assert.*;

import java.util.*;

public class GenericBSTTest {
	private GenericBST<Integer> bst1;
	private GenericBST<Integer> bst2;
	private final Comparator<Integer> IntergerCompare = new IntegerComparator();
	@Before
	public void setUp(){
		bst1 = new GenericBST<Integer>(IntergerCompare);
		bst2 = new GenericBST<Integer>(IntergerCompare);
	}
	@Test
	public void getCommonsWithTest1(){
		bst1.addAll(new Integer[]{25,20,10,22,50,35,65});
		bst2.addAll(new Integer[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWith(bst2);
		Integer[] expecteds = new Integer[]{35, 50, 65};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWith(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithTest2(){
		bst1.addAll(new Integer[]{});
		bst2.addAll(new Integer[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWith(bst2);
		Integer[] expecteds = new Integer[]{};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWith(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithTest3(){
		bst1.addAll(new Integer[]{100});
		bst2.addAll(new Integer[]{100});
		List<Integer> commons =  bst1.getCommonsWith(bst2);
		Integer[] expecteds = new Integer[]{100};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWith(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithIteratorTest1(){
		bst1.addAll(new Integer[]{25,20,10,22,50,35,65});
		bst2.addAll(new Integer[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithIterator(bst2);
		Integer[] expecteds = new Integer[]{35, 50, 65};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithIteratorTest2(){
		bst1.addAll(new Integer[]{});
		bst2.addAll(new Integer[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithIterator(bst2);
		Integer[] expecteds = new Integer[]{};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithIteratorTest3(){
		bst1.addAll(new Integer[]{100});
		bst2.addAll(new Integer[]{100});
		List<Integer> commons =  bst1.getCommonsWithIterator(bst2);
		Integer[] expecteds = new Integer[]{100};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithMorrisIteratorTest1(){
		bst1.addAll(new Integer[]{25,20,10,22,50,35,65});
		bst2.addAll(new Integer[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithMorrisIterator(bst2);
		Integer[] expecteds = new Integer[]{35, 50, 65};
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithMorrisIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithMorrisIteratorTest2(){
		bst1.addAll(new Integer[]{});
		bst2.addAll(new Integer[]{100,50,35,65,125,150,200});
		List<Integer> commons =  bst1.getCommonsWithMorrisIterator(bst2);
		Integer[] expecteds = new Integer[]{};;
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));
		commons =  bst2.getCommonsWithMorrisIterator(bst1);
		assertArrayEquals(expecteds, commons.toArray(new Integer[commons.size()]));			
	}
	@Test
	public void getCommonsWithMorrisIteratorTest3(){
		bst1.addAll(new Integer[]{100});
		bst2.addAll(new Integer[]{100});
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
