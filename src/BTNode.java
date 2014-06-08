
public class BTNode <T> {
	private  T data = null;
	private BTNode left = null;
	private BTNode right = null;
	private BTNode parent = null;
	public BTNode(T data, BTNode<T> left, BTNode<T> right, BTNode<T> parent){
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
		this.setParent(parent);
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public BTNode getRight() {
		return right;
	}
	public void setRight(BTNode right) {
		this.right = right;
	}
	public BTNode getParent() {
		return parent;
	}
	public void setParent(BTNode parent) {
		this.parent = parent;
	}
	public BTNode getLeft() {
		return left;
	}
	public void setLeft(BTNode left) {
		this.left = left;
	}
}
