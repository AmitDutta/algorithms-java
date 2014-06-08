package dp;

public class Lis {
	
	public int doList(int[] a){
		int i = 0;
		int[] s = new int[a.length];
		for (i = 0; i < s.length; i++) s[i] = 1;
		for (i = 1; i < a.length; i++){
			for (int j = 0; j < i; j++){
				if(a[j] <= a[i] && ((s[j] + 1) > s[i])){
					s[i] = s[j] + 1;
				}else{
					s[i] = s[j];
				}
			}
		}
		return s[s.length - 1];
	}
	
	public static void main(String[] args){
		Lis lis = new Lis();
		System.out.println(lis.doList(new int[]{5, 3, 4, 8, 6, 7}));
		System.out.println(lis.doList(new int[]{7, 2, 8, 1, 3, 4, 10, 6, 9, 5}));
		System.out.println(lis.doList(new int[]{3, 4, 1}));
	}
}
