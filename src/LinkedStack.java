
public class LinkedStack<T> {	
	private class Node{
		T data;
		Node next;
	}
	private Node top;
	private int N;
	public LinkedStack(){
		N = 0;
	}
	public void push(T item){
		Node oldTop = top;
		top = new Node();
		top.data = item;
		top.next = oldTop;
		N++;
	}
	public T pop(){
		T val = top.data;
		Node cur = top;
		top = top.next;
		cur = null;
		N--;
		return val;
	}
	public T peek(){
		return top.data;
	}
	public boolean isEmpty(){ return top == null; }	// return N == 0;
	
	public static void main(String[] args){
		LinkedStack<Integer> stack = new LinkedStack<Integer>();
		System.out.println(stack.isEmpty());
		stack.push(new Integer(1));
		stack.push(new Integer(2));
		stack.push(new Integer(3));
		while(!stack.isEmpty()){
			Integer item = stack.pop();
			System.out.println(item);
		}
		
		System.out.println();
	}
}
