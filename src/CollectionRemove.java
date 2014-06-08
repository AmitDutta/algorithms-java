import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;


public class CollectionRemove {
	public static void main(String[] args){
		List<Integer> items = new ArrayList<Integer>();
		items.add(5);
		items.add(6);
		items.add(7);
		Iterator<Integer> it = items.iterator();
		while(it.hasNext()){
			if (it.next() < 15) it.remove(); // next is vv imp
		}
		System.out.println(items.size());
	}
}
