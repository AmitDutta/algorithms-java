import static org.junit.Assert.*;

import java.awt.print.Printable;

import org.junit.Test;


public class SingleLinkedList {
	private LinkedListNode head = null;
	public SingleLinkedList(){
		
	}
	
	public LinkedListNode add(int[] data){
		for (int i = 0; i < data.length; i++){
			if (head == null){
				head = new LinkedListNode(data[i]);
				head.setNext(null);
			}else{
				LinkedListNode cur = head;
				while (cur.getNext() != null){
					cur = cur.getNext();
				}
				LinkedListNode newNode = new LinkedListNode(data[i]);
				newNode.setNext(null);
				cur.setNext(newNode);
			}			
		}
		return head;
	}
	
	public void print() { print(head);}
	
	public void print(LinkedListNode head){
		LinkedListNode cur = head;
		while (cur != null){
			System.out.print(cur.getData() + " ");
			cur = cur.getNext();
		}
		System.out.println("--");
	}
	
	public LinkedListNode getHead() {
		return this.head;
	}
	public void setHead(LinkedListNode head){
		this.head = head;
	}
	
	public boolean hasLoops(LinkedListNode head){
		boolean hasLoops = false;
		LinkedListNode fast, slow;
		fast = slow = head;
		while (true){
			if (fast == null || fast.getNext() == null){
				hasLoops = false;
				break;
			}
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if (fast == null){
				hasLoops = false;
				break;
			}
			if (fast.getData() == slow.getData()){
				hasLoops = true;
				break;
			}
		}
		return hasLoops;
	}
	
	public LinkedListNode findStartofLoop(LinkedListNode head){
		if (!hasLoops(head)) return null;		
		LinkedListNode fast, slow;
		fast = slow = head;
		while (true){
			if (fast == null || fast.getNext() == null){				
				break;
			}
			fast = fast.getNext().getNext();
			slow = slow.getNext();
			if (fast == null){				
				break;
			}
			if (fast.getData() == slow.getData()){				
				break;
			}
		}
		fast = head;
		while (fast.getData() != slow.getData()){
			fast = fast.getNext();
			slow = slow.getNext();
		}
		return fast;
	}
	
	public LinkedListNode reverse(LinkedListNode head){
		LinkedListNode p, q, r;
		q = r = null;
		p = head;
		while (p  != null) {
			q = p;
			p = p.getNext();
			q.setNext(r);
			r = q;
		}
		return q;
	}
	
	public LinkedListNode recReverse(LinkedListNode head, LinkedListNode prev){
		if (head == null) return prev;
		LinkedListNode q = head.getNext();
		head.setNext(prev);
		return recReverse(q, head);
	}
	
	public LinkedListNode getLastNode(LinkedListNode head){
		while (head.getNext() != null){
			head = head.getNext();
		}
		return head;
	}
	
	public LinkedListNode reverseKth(LinkedListNode head, int k){
		if (head == null) return null;
		
		LinkedListNode cur = head;
		LinkedListNode result = null;
		LinkedListNode next = head;
		LinkedListNode start;
		while (next != null){
			cur = next;
			start = cur;
			for (int i = 1; i < k; i++){
				if (cur == null) {					
					break;				
				}
				cur = cur.getNext();
			}
			if (cur != null){
				next = cur.getNext();
				cur.setNext(null);				
				if (result == null){
					result = this.reverse(start);
				}else{
					LinkedListNode lastNode = this.getLastNode(result);
					LinkedListNode firstNode = this.reverse(start);
					lastNode.setNext(firstNode);
				}				
			}else{
				this.getLastNode(result).setNext(start);
				break;
			}
		}
		return result;
	}
	
	public LinkedListNode deleteAll(LinkedListNode head, int data){
		if (head == null) return null;
		LinkedListNode returnHead = head;
		LinkedListNode prev = head;
		LinkedListNode cur = head.getNext();
		while (cur != null){
			if (cur.getData() == data){
				prev.setNext(cur.getNext());
				cur = prev.getNext();
			}else{
				prev = cur;
				cur = cur.getNext();
			}
		}
		return returnHead.getData() == data ? returnHead.getNext() : returnHead;
	}
	
	public LinkedListNode reverseRec(LinkedListNode nd){
		if (nd == null || nd.getNext() == null){
			head = nd;
			return nd;
		}	
		LinkedListNode p = reverseRec(nd.getNext());
		p.setNext(nd);
		nd.setNext(null);
		return nd;
		
	}
	
	public void swapKth(LinkedListNode head, int k){
		LinkedListNode cur = head;
		LinkedListNode cur_prev = null, p = null, p_prev = null, q = null, q_prev = null;		
		int count = 0;		
		while (cur != null){
			if (count == k - 1){
				p = cur;
				p_prev = cur_prev;
				break;
			}
			count++;
			cur_prev = cur;
			cur = cur.getNext();
		}
	
		cur = head;
		LinkedListNode late_cur = null;
		LinkedListNode late_cur_prev = null;
		int tmp = 0;
		while (cur != null){
			if (tmp == k){
				late_cur = head;
				late_cur_prev = null;
			}
			tmp++;
			cur = cur.getNext();
			if (late_cur != null) {
				late_cur_prev = late_cur;
				late_cur = late_cur.getNext();
			}
		}
		if (tmp == k){
			late_cur = head;
			late_cur_prev = null;
		}
		q = late_cur;
		q_prev = late_cur_prev; 
		// swap
		
		LinkedListNode p_next = p.getNext();
		LinkedListNode q_next = q.getNext();
		//cases
		if (q_prev == null){
			// swap first node and last node
			p.setNext(q_next);
			p_prev.setNext(q);
			q.setNext(null);
			head = p;
		}
		else if (p_prev == null){
			q.setNext(p_next);
			q_prev.setNext(p);
			p.setNext(null);
			head = q;
		}
		else if (p_next == q){
			// swap p and q
			p_prev.setNext(q);
			q.setNext(p);
			p.setNext(q_next);
		}
		else if (q_next == p){
			q_prev.setNext(p);
			q.setNext(p_next);
			p.setNext(q);
		}
		else{
			p_prev.setNext(q);
			q.setNext(p.getNext());
			
			q_prev.setNext(p);
			p.setNext(q_next);
		}
		print(head);
	}	
	public static void main(String[] args){
		SingleLinkedList list = new SingleLinkedList();
		LinkedListNode one = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		LinkedListNode four = new LinkedListNode(4);
		LinkedListNode five = new LinkedListNode(5);
		LinkedListNode six = new LinkedListNode(6);
		LinkedListNode seven = new LinkedListNode(7);
		LinkedListNode eight = new LinkedListNode(8);
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(six);
		six.setNext(seven);
		seven.setNext(eight);
		
		
		list.swapKth(one, 6);
		
	}
	
	@Test
	public void reverseRecTest(){
		LinkedListNode one = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		
		one.setNext(two);
		two.setNext(three);
		reverseRec(one);
		print();
	}
	
	@Test
	public void deleteAllTest(){
		LinkedListNode one = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(5);
		LinkedListNode three = new LinkedListNode(5);
		LinkedListNode four = new LinkedListNode(6);
		LinkedListNode five = new LinkedListNode(5);
		LinkedListNode six = new LinkedListNode(6);
		
		/*one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(six);*/
		
		LinkedListNode head = deleteAll(two, 6);
		print(head);
	}
	
	@Test
	public void loopTest1(){
		LinkedListNode one = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		LinkedListNode four = new LinkedListNode(4);
		LinkedListNode five = new LinkedListNode(5);
		LinkedListNode six = new LinkedListNode(6);
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(one);		
		assertTrue(hasLoops(one));
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);		
		assertFalse(hasLoops(one));
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(six);
		six.setNext(two);
		assertTrue(hasLoops(one));
		
		assertFalse(hasLoops(null));
		
		one.setNext(two);
		two.setNext(one);
		assertTrue(hasLoops(one));
		
		one.setNext(one);
		assertTrue(hasLoops(one));
	}
	
	@Test
	public void loopstarttest1(){
		LinkedListNode one = new LinkedListNode(1);
		LinkedListNode two = new LinkedListNode(2);
		LinkedListNode three = new LinkedListNode(3);
		LinkedListNode four = new LinkedListNode(4);
		LinkedListNode five = new LinkedListNode(5);
		LinkedListNode six = new LinkedListNode(6);
		
		one.setNext(two);
		two.setNext(one);
		assertEquals(one.getData(), findStartofLoop(one).getData());
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(one);	
		assertEquals(one.getData(), findStartofLoop(one).getData());
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);		
		assertEquals(null, findStartofLoop(one));
		
		one.setNext(two);
		two.setNext(three);
		three.setNext(four);
		four.setNext(five);
		five.setNext(six);
		six.setNext(two);
		
		assertEquals(two.getData(), findStartofLoop(two).getData());
	}

	@Test
	public void reverseTest1(){
		SingleLinkedList lst = new SingleLinkedList();
		lst.add(new int[]{1,2,3,4});		
		LinkedListNode head = lst.reverse(lst.getHead());
		while (head != null){
			System.out.print(head.getData() + " ");
			head = head.getNext();
		}
	}

	@Test
	public void reverseKthTest1(){
		SingleLinkedList lst = new SingleLinkedList();
		lst.add(new int[]{1,2,3,4,5,6});
		LinkedListNode head = lst.reverseKth(lst.getHead(), 3);
		print(head);
		
		SingleLinkedList lst1 = new SingleLinkedList();
		lst1.add(new int[]{1,2,3,4,5,6});
		LinkedListNode head1 = lst1.reverseKth(lst1.getHead(), 2);
		print(head1);
		
		SingleLinkedList lst2 = new SingleLinkedList();
		lst2.add(new int[]{1,2,3,4,5,6,7,8,9,10,11});
		LinkedListNode head3 = lst2.reverseKth(lst2.getHead(), 4);
		print(head3);
	}

	@Test
	public void recReverseTest(){
		System.out.println("recReverseTest");
		SingleLinkedList lst = new SingleLinkedList();
		lst.add(new int[]{1,2,3,4,5,6});
		LinkedListNode node = lst.recReverse(lst.getHead(),null);
		lst.print(node);
	}
}
