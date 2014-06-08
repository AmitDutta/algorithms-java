import static org.junit.Assert.*;

import org.junit.Test;

public class BinarySearch {
	//THIS METHOD IS BUGGY !! SEE ROTATION.JAVA
	public int rotationIndex(int[] input){
		int low = 0;
		int high = input.length - 1;
		while(true){
			if (low >= high){
				break;
			}
			int mid = low + (high - low)/2;
			if (input[low] > input[mid]){
				high = mid;
			}else {
				low = mid + 1;
			}
		}
		return low;
	}
	
	public int binarySearch(int[] array, int low, int high, int value){
		if (low > high) return -1;
		int mid = low + (high - low)/2;
		return array[mid] == value ? mid : array[mid] > value ? 
				binarySearch(array, low, mid -1, value) : binarySearch(array, mid + 1, high, value); 
	}
	
	public int findinrotatedarray(int[] array, int value){
		int index = rotationIndex(array);
		int found = binarySearch(array, 0, index, value);
		if (found == - 1){
			found = binarySearch(array, index + 1 , array.length - 1, value);
		}
		return found;
	}
	
	@Test
	public void splitpointtest(){
		BinarySearch search = new BinarySearch();
		assertEquals(1, search.rotationIndex(new int[] {4,1,2,3}));
		assertEquals(3, search.rotationIndex(new int[] {4,5,6,1,2,3}));
		assertEquals(1, search.rotationIndex(new int[] {7, 1, 2, 3, 4, 5, 6}));
		assertEquals(6, search.rotationIndex(new int[] { 2, 3, 4, 5, 6, 7, 1}));
		assertEquals(4, search.rotationIndex(new int[] {60, 70, 80, 90, 10, 20, 30, 40, 50}));		
	}
	
	@Test
	public void binarySearchTest(){
		BinarySearch search = new BinarySearch();
		assertEquals(5, search.binarySearch(new int[] {10,20,30,40,50,60}, 0, 5, 60));
		assertEquals(-1, search.binarySearch(new int[] {70,80,90,100,110,120}, 0, 5, 50));
		assertEquals(0, search.binarySearch(new int[] {70,80,90,100,110,120}, 0, 5, 70));
		assertEquals(-1, search.binarySearch(new int[] {160}, 0, 0, 96 ));
	}
	
	@Test
	public void findinroatedarrayTest(){
		BinarySearch search = new BinarySearch();
		assertEquals(6, search.findinrotatedarray(new int[] {7, 1, 2, 3, 4, 5, 6}, 6));
		assertEquals(0, search.findinrotatedarray(new int[] {7, 1, 2, 3, 4, 5, 6}, 7));
		assertEquals(-1, search.findinrotatedarray(new int[] {7, 1, 2, 3, 4, 5, 6}, 55));
	}
}
