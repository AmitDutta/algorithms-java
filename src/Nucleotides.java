
public class Nucleotides {
	public int[] solution(String S, int[] P, int[] Q) {
		int[] result = new int[P.length];
		for (int i = 0; i < P.length; i++){
			char ch = S.charAt(P[i]);
			for (int j = P[i]; j <= Q[i]; j++){
				if (S.charAt(j) < ch) ch = S.charAt(j);
			}
			result[i] = getCode(ch);
		}
		return result;
    }
	public int getCode(char ch){
		if (ch == 'A') return 1;
		if (ch == 'C') return 2;
		if (ch == 'G') return 3;
		if (ch == 'T') return 4;
		return -1;
	}
	
	public int unique(int[] array){
		int result = -1;
		for (int i = 0; i < array.length; i++){
			if (array[i] != i + 1){
				result = array[i];
				if (result > array.length) array[array[i]] = -1;
				else{
					result = array[array[i]];
					array[array[i]] = array[i];
				}
			}
		}
		
		for (int i = 0; i < array.length; i++){
			if (array[i] != (i + 1)){
				result = i + 1;
				break;
			}
		}
		
		return result;
	}
	
	public int missing(int[] array){
		int missing = 0;
		for (int i = 0; i < array.length; i++){
			missing ^= i ^ array[i];
		}
		return missing^array.length^array.length+1;
	}
	
	public int min(int[] A, int N){
		if (A.length == 1){
			return -1;
		}
		
		int min = Integer.MAX_VALUE;
		int[] B = new int[A.length];
		B[0] = A[0];
		for (int i = 1; i < A.length; i++){
			B[i] = A[i] + B[i - 1];
		}		
		
		min = B[0];
		for (int p = 1; p < B.length - 1; p++){
			if (Math.abs(B[p-1] - (B[B.length - 1] - B[p - 1])) < min){
				min = Math.abs(B[p-1] - (B[B.length - 1] - B[p - 1]));
			}
		}
		
		return min;		
	}
	
	public static void main(String[] args){
		Nucleotides obj = new Nucleotides();
		/*int[] result = obj.solution("GACACCATA", new int[]{0,0,4,7}, new int[]{8,2,5,7});
		for (int i = 0; i < result.length; i++) System.out.println(result[i]); */
		/*int i = (int) Math.ceil(85/30); 
		System.out.println(Math.ceil(85.0/30.0));
		System.out.println(obj.unique(new int[] {2,3,1,5})); */
		/*System.out.println(obj.missing(new int[] {2,3,1,5}));*/
		System.out.println(obj.min(new int[]{3,1}, 2));
		
	}
}
