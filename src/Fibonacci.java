
public class Fibonacci {
	
	public int getFibonacci(int n){
		int result = 0;
		int first, second;
		first = second = 1;
		if (n < 0) result = -1;
		else if (n == 0) result = 0;
		else if (n == 1 || n == 2) result = first;
		else {
			int temp = 0;
			for (int i = 3; i <= n; i++){
				temp = first;
				first = first + second;
				second = temp;
				
			}
			result = first;
		}
		
		return result;
	}
	
	public static void main(String[] args){
		Fibonacci fibonacci = new Fibonacci();
		for (int i = 0; i < 10; i++){
			System.out.println(fibonacci.getFibonacci(i));
		}
	}
}
