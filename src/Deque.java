import java.util.Iterator;

public class Deque<T> {
	private class Node{
		T data;
		Node next;
		Node prev;
	}
	private int N;
	private Node first;
	private Node last;
	public boolean isEmpty(){return N == 0; }
	public int size(){return N;}
	public void addFirst(T item){
		Node oldFirst = first;		
		first = new Node();
		first.data = item;
		first.next = oldFirst;
		if (isEmpty()) last = first;
		else{
			oldFirst.prev = first;
		}		
		N++;
	}
	public void addLast(T item){
		Node oldLast = last;
		last = new Node();
		last.data = item;
		if (isEmpty()) first = last;
		else {
			oldLast.next = last;
			last.prev = oldLast;
		}
		N++;
	}
	public T removeFirst(){
		T val = first.data;
		first = first.next;
		N--;
		return val;
	}
	public T removeLast(){
		T val = last.data;
		last = last.prev;
		N--;
		return val;
	}
	
	public Iterator<T> getIterator() {return new DequeIterator(); }
	
	private class DequeIterator implements Iterator<T>{

		private Node current = first;
		@Override
		public boolean hasNext() { return current != null; }

		@Override
		public T next() {			
			T val = current.data;
			current = current.next;
			return val;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args){
		Deque<Integer> dq = new Deque<>();
		dq.addFirst(1);
		dq.addLast(2);
		dq.addFirst(4);
		dq.addLast(3);
		dq.addFirst(5);
		dq.addLast(2);
		dq.addFirst(6);
		
		/*while(!dq.isEmpty()){
			Integer item = dq.removeLast();
			System.out.println(item);
		}*/
		Iterator<Integer> it = dq.getIterator();
		while(it.hasNext()){
			Integer val = it.next();
			System.out.println(val);
		}
		
	}
}
