
public class LinkedListNode {
	private LinkedListNode next;
	private int data;
	public LinkedListNode(int data){
		this.data = data;
	}
	public int getData() { return this.data; }
	public void setData(int data) { this.data = data; }
	public LinkedListNode getNext() {
		return next;
	}
	public void setNext(LinkedListNode next) {
		this.next = next;
	}
}
