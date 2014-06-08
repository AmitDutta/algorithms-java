import static org.junit.Assert.*;
import org.junit.Test;

public class ZeroAndOne {
	public static void exch(int[]a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	// Definitely not a very good algorithm !
	//just partition the array on 1 !
	// Sort an array with 0, 1, 2..same thing..partition the array on 1
	public static void sort(int[] a){
		int cur_one = -1;
		for (int i = 0; i < a.length;){
			if (a[i] == 1){
				if (cur_one == -1) cur_one = i;
				i++;
			}else{
				if (cur_one != -1){
					exch(a, cur_one, i);
					i = cur_one + 1;
					cur_one = -1;
				}else i++;
			}
		}
	}
	
	@Test
	public void testSort(){
		// SEE THE CORNER CASES
		int arr1[]= {1,1,1,0,0};
		sort(arr1);
		int arr1Expected[]= {0,0,1,1,1};		
		assertArrayEquals(arr1Expected, arr1);
		
		
		int arr2[]= {0,1,0,1};
		sort(arr2);
		int arr1Expected2[]= {0,0,1,1};
		assertArrayEquals(arr1Expected2, arr2);
	}
	public static void main(String[] args){
		
	}
}
