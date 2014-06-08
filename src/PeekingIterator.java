import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class PeekingIterator<T> implements Iterator<T> {
	private Iterator<T> iterator;
	private boolean peeked;
	private T peekedItem;
	public PeekingIterator(Iterator<T> iterator){
		this.iterator = iterator;
		peeked = false;
	}
		
	public T peek(){
		if (!peeked){
			peekedItem = iterator.next();
			peeked = true;			
		}
		return peekedItem;
	}
	public boolean hasNext() {		
		return peeked || iterator.hasNext();
	}
	@Override
	public T next() {
		// same logic but more cleaner
		if (!peeked) return iterator.next();
		T item = peekedItem;
		peeked = false;
		peekedItem = null;
		return item;
		/*T item = null;		
		if (peeked){
			item = peekedItem;
			peeked = false;
			peekedItem = null; // memory leak and loitering
			
		}else{
			item = iterator.next();
			peeked = false;
		}
		return item;*/
	}
	@Override
	public void remove() {
		iterator.remove();
	}
	
	public static void main(String[] args){
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(5);
		lst.add(6);
		lst.add(7);
		PeekingIterator<Integer> it = new PeekingIterator<>(lst.iterator());
		while(it.hasNext()){
			Integer item = it.peek();
			System.out.println(item);
			item = it.peek();
			System.out.println(item);
			item = it.next();
			System.out.println(item);
		}
	}
}
