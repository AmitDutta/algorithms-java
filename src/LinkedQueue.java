
public class LinkedQueue<T> {
	private class Node{
		T data;
		Node next;
	}
	private Node first;
	private Node last;
	private int N;
	
	public boolean isEmpty(){
		return N == 0;
	}
	public void enqueue(T item){
		Node oldLast = last;
		last = new Node();
		last.data = item;
		if (isEmpty()) first = last;
		else oldLast.next =last;
		N++;
	}
	public T deque(){
		T val = first.data;
		first = first.next;
		N--;
		return val;
	}	
	public static void main(String[] args){
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		queue.enqueue(new Integer(1));
		queue.enqueue(new Integer(2));
		queue.enqueue(new Integer(3));
		while(!queue.isEmpty()){
			Integer item = queue.deque();
			System.out.println(item);
		}
	}

}
