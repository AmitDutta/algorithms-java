
public class Permutation_Test {
	public static void perm_no_repeat(String str, StringBuffer br, int len, int cur, boolean[] marked){
		if (cur == len){
			System.out.println(br.toString());
			return;
		}else{
			for (int i = 0; i < str.length(); i++){
				if (marked[i]) continue;
				marked[i] = true;
				br.append(str.charAt(i));
				perm_no_repeat(str, br, len, cur + 1, marked);
				marked[i] = false;
				br.setLength(br.length() - 1);
			}
		}			
	}
	
	// for perm_with_reapeat just do not use the marked array
	public static void combination(String str, StringBuffer br, int len, int cur, boolean[] marked, int start){
		if (cur == len){
			System.out.println(br.toString());
			return;
		}else{
			for (int i = start; i < str.length(); i++){
				if (marked[i]) continue;
				marked[i] = true;
				br.append(str.charAt(i));
				combination(str, br, len, cur + 1, marked, start + 1);
				marked[i] = false;
				br.setLength(br.length() - 1);
			}
		}			
	}	
	
	public static void print_all_combination(String str){
		for (int i = 1; i <= str.length(); i++){
			combination(str, new StringBuffer(), i, 0, new boolean[str.length()], 0);
		}
	}
	
	//FAQ.. with 3 bit (option 0 and 1), we get 8 items. that comes this way: 2*2*2
	// at permutation order matters...therefore with abc, we get 8 permutations, but they are 1 combination
	//so, for permuation we need to start from 0 and use marked array. for perm without repeatation no marked array
	// for combiantion, (i.e. how many ways we can pick 3 items from 5, use marked array and also start from ith position.
	// abcd..when abc is printed, we do not need bac.. so use start and marked both
		
	public static void main(String[] s){
		String str = "abc";
		perm_no_repeat(str, new StringBuffer(), str.length(), 0, new boolean[str.length()] );
		System.out.println();
		//perm_test(str, new StringBuffer(), str.length(), 0, new boolean[str.length()] , 0);
		
		print_all_combination("abc"); // prints all combination of length 1, 2 and 3. look with 3, we get only one combination, which is right. abc and bca etc are same in combination
	}
}
