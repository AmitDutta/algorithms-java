// We assume that both of the linked lists are sorted

// just consider two case 1-3-5-7 and 2-4-6-7, 1-5-10 and 1-3

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListMerge {	
	public LinkedListNode merge(LinkedListNode node1, LinkedListNode node2){
		LinkedListNode head = null;
		LinkedListNode temp = null;
		if (node1 == null) return node2;
		if (node2 == null) return node1;
		if (node1.getData() <= node2.getData()){
			head = node1;
		}else{
			temp = node1;
			node1 = node2;
			node2 = temp;
			head = node1;
		}
		while (true){
			if (node1.getNext() == null) break;
			if (node2 == null) break;
			if (node1.getNext().getData() <= node2.getData()){
				node1 = node1.getNext();
			}else {
				temp = node1.getNext();
				node1.setNext(node2);
				node2 = temp;
			}
		}
		if (node1.getNext() == null) node1.setNext(node2);
		return head;
	}
	
	
	@Test
	public void sortTest1(){		
		int[] array1 = {1,3,5,7};
		int[] array2 = {2,4,6,7};
		runtest(array1, array2);
	}

	@Test
	public void sortTest2(){		
		int[] array1 = {};
		int[] array2 = {2,4,6,7};
		runtest(array1, array2);
	}
	
	@Test
	public void sortTest4(){		
		int[] array1 = {};
		int[] array2 = {};
		runtest(array1, array2);
	}
	
	@Test
	public void sortTest3(){		
		int[] array1 = {100,200};
		int[] array2 = {2,4,6,7};
		runtest(array1, array2);
	}
	
	public void runtest(int[] array1, int[] array2){
		LinkedListMerge merger = new LinkedListMerge();
		SingleLinkedList list1 = new SingleLinkedList();
		list1.add(array1);			
		SingleLinkedList list2 = new SingleLinkedList();
		list2.add(array2);
		print(merger.merge(list1.getHead(), list2.getHead()));
	}
	
	public void print(LinkedListNode list3){
		while (list3 != null) {
			System.out.print(list3.getData() + " ");
			list3 = list3.getNext();			
		}
		System.out.println("-->");
	}
}
