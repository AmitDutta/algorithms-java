import java.util.Arrays;


public class SuffixArray {
	public static void main(String[] args){
		String str = "amit";
		String[] suffixes = new String[str.length()];
		for (int i = 0; i < str.length(); i++){
			suffixes[i] = str.substring(i, str.length());
		}
		Arrays.sort(suffixes);
		for (int i = 0; i < suffixes.length; i++){
			System.out.println(suffixes[i]);
		}
	}
}
