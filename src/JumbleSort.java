import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;;

// See ThreeWayPartition file

public class JumbleSort {
	private final int NotCompareable = -10;
	private String[] strings;
	private String[] b;
	public JumbleSort(String input){
		strings = input.split(" +");
	//	b = new String[strings.length];
		print(sort());
		//quicksort(0, strings.length - 1);
		//mergesort(0, strings.length - 1);
//		/print(strings);
		
		
	}
	private void mergesort(int low, int high){
		if (low < high){
			int mid = (low + high)/2;
			mergesort(low, mid);
			mergesort(mid + 1, high);
			merge(low, mid, high);
		}
	}
	private void merge(int low, int mid, int high){
		int h = low, i = low, j = mid + 1;
		while (h <= mid && j <= high){
			int val = compare(strings[h], strings[j]);
			if (val != NotCompareable){
				if (val <= 0){
					b[i] = strings[h];
					h++;
				}else{
					b[i] = strings[j];
					j++;
				}
			}else{
				h++;
				j++;
			}
			i++;
		}
		if (h > mid){
			for (int k = j; k <= high; k++){
				b[i] = strings[k];
				i++;
			}
		}else{
			for (int k = j; k <= mid; k++){
				b[i] = strings[k];
				i++;
			} 
		}
		for (int k = low; k <= high; k++) strings[k] = b[k];
	}
	private void quicksort(int p, int r){
		if (p < r){
			int q = partition(p, r);
			quicksort(p, q - 1);
			quicksort(q + 1, r);
		}
	}
	private int partition(int p, int r){		
		String x = strings[r];
		int  i = p - 1;
		for (int j = p; j < r; j++){
			int val = compare(strings[j], x);
			if (val != NotCompareable && val < 0){
				i++;
				String temp = strings[j];
				strings[j] = strings[i];
				strings[i] = temp;
			}
		}
		i++;
		if (compare(strings[i], strings[r]) != NotCompareable){
			String temp = strings[r];
			strings[r] = strings[i];
			strings[i] = temp;
		}		
		return i;
	}
	private int compare(String str1, String str2){
		int val = NotCompareable;
		if (Character.isDigit(str1.charAt(0)) && Character.isDigit(str2.charAt(0))){
			int val1 = Integer.parseInt(str1);
			int val2 = Integer.parseInt(str2);
			val = val1 == val2 ? 0 : val1 > val2 ? 1 : -1;
		}else if (Character.isLetter(str1.charAt(0)) && Character.isLetter(str2.charAt(0))){
			val = str1.compareTo(str2);
		}
		return val;
	}
	public String[] sort(){
		String[] result = new String[strings.length];
		List<String> strs = new ArrayList<String>();
		List<String> nums = new ArrayList<String>();
		for (String str : strings){;
			if (Character.isLetter(str.charAt(0))) strs.add(str);
			else nums.add(str);
		}
		Collections.sort(strs);
		Collections.sort(nums);
		int p = 0, q = 0;
		for (int i = 0; i < strings.length; i++){
			if (Character.isLetter(strings[i].charAt(0))){
				result[i] = strs.get(p);
				p++;
			}else{
				result[i] = nums.get(q);
				q++;
			}
		}		
		return result;
	}
	public void print(String[] result){
		for (int i= 0; i < result.length; i++) System.out.print(result[i] + " ");
		System.out.println();
	}
	
    public static void main(String args[] ) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	String input = sc.nextLine();
    	JumbleSort solve = new JumbleSort(input);
    }
}