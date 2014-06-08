
public class Numbers {	
	
	public int reverse(int number){
		int result = 0;
		while (number > 0){
			result = result * 10 + (number % 10);
			number /= 10;
		}
		return result;
	}
	
	public boolean ispalindrome(int number){
		int[] a = new int[20];
		boolean ispal = true;
		int index = 0;
		while(number > 0){
			a[index++] = number % 10;
			number /= 10;
		}
		for (int i = 0, j = index - 1; i <= j; i++, j--){
			if (a[i] != a[j]){
				ispal = false;
				break;
			}
		}
		return ispal;
	}
	
	public static void main(String[] args){
		Numbers num = new Numbers();
		System.out.println(num.reverse(12000));
		System.out.println(num.ispalindrome(121));
		short i = 5;
	}
}
