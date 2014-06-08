import java.util.Stack;


public class Hanoi {
	private Stack<Integer> source;
	private Stack<Integer> auxilary;
	private Stack<Integer> destination;
	private int n;
	
	public Hanoi(int n){
		this.n = n;
		source = new Stack<Integer>();
		auxilary = new Stack<Integer>();
		destination = new Stack<Integer>();
		while (n >= 1){
			source.push(n);
			n--;
		}
		solve(this.n, source, auxilary, destination);
		getResult();
	}
	
	private void solve(int items, Stack<Integer> source, Stack<Integer> auxilary, Stack<Integer> destination){
		if (items <= 0) return;
		else{
			solve(items - 1, source, destination, auxilary);
			destination.push(source.pop());
			solve(items - 1, auxilary, source, destination);
		}		
	}
	
	public void getResult(){
		while(!destination.empty()){
			System.out.println(destination.pop());
		}
	}
	
	public static void main(String[] args){
		Hanoi hanoi = new Hanoi(4);
	}
}
