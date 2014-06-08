
public class SquareRoot {
	public static int getRoot(int n){
		int high = 1 + (n/2);
		int low = 0;
		int mid = 0;
		while (true){
			if ((low + 1) >= high){
				break;
			}
			mid = low + (high - low)/2;
			int square = mid * mid;
			if (square == n) return mid;
			else if (square > n) high = mid;
			else low = mid;
		}
		return low;
	}
	public static void main(String[] args){
		System.out.println(getRoot(1000));
	}
}
