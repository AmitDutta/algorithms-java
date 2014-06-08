import java.util.Iterator;
public interface IteratorWithPeek<E> extends Iterator<E> {
	public E peek();
}
