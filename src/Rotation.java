import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Rotation {	
	public static int getRotationIndex(int[] array){		
		int low = 0;
		int initialLow = low;
		int high = array.length - 1;
		while(true){
			if (low >= high) return low;
			if (high == low + 1){
				/*The subproblem has two element; and we can decide from here.*/
				if (array[low] > array[high]) return high;
				return initialLow;
			}
			int mid = low + (high - low)/2;
			if (array[low] > array[mid]){
				high = mid;
			}else {
				low = mid;
			}
		}		
	}
	@Test
	public void getRotationIndexTest(){
		assertEquals(0, Rotation.getRotationIndex(new int[] {2}));
		assertEquals(1, Rotation.getRotationIndex(new int[] {2, 1}));
		assertEquals(2, Rotation.getRotationIndex(new int[] {2, 3, 1}));		
		assertEquals(6, Rotation.getRotationIndex(new int[]{2, 3, 4, 5, 6, 7, 1}));
		assertEquals(0, Rotation.getRotationIndex(new int[]{1, 2, 3, 4, 5, 6, 7}));
		assertEquals(1, Rotation.getRotationIndex(new int[] {7, 1, 2, 3, 4, 5, 6}));		
		assertEquals(4, Rotation.getRotationIndex(new int[] {60, 70, 80, 90, 10, 20, 30, 40, 50}));
		assertEquals(3, Rotation.getRotationIndex(new int[] {4, 5, 6, 1, 2, 3}));
		assertEquals(4, Rotation.getRotationIndex(new int[] {5, 6, 7, 8, 1, 2, 3, 4}));
		assertEquals(5, Rotation.getRotationIndex(new int[] {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}));		

	}
	
	public static void main(String[] args){
		System.out.println(Rotation.getRotationIndex(new int[]{2, 3, 4, 5, 6, 7, 1})); // should be 6
		System.out.println(Rotation.getRotationIndex(new int[]{1, 2, 3, 4, 5, 6, 7})); // should be 0
		System.out.println(Rotation.getRotationIndex(new int[] {7, 1, 2, 3, 4, 5, 6})); // should be 1
		System.out.println(Rotation.getRotationIndex(new int[] {60, 70, 80, 90, 10, 20, 30, 40, 50})); // should be 4
		System.out.println(Rotation.getRotationIndex(new int[] {2, 1})); // should be 1
		System.out.println(Rotation.getRotationIndex(new int[] {2})); // should be 0		
		System.out.println(Rotation.getRotationIndex(new int[]{4, 5, 6, 1, 2, 3})); // should be 3
		System.out.println(Rotation.getRotationIndex(new int[]{5, 6, 7, 8, 1, 2, 3, 4})); // should be 4
	}
}
