import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class GenericBST<T> {
	private BstNode root = null;	
	private Comparator<T> comparator = null;
	private class BstNode{
		private T data = null;
		private BstNode left = null;
		private BstNode right = null;
	}
	public GenericBST(Comparator<T> comparator){
		this.comparator = comparator;
	}
	public void addAll(T[] data){
		for (int i = 0; i < data.length; i++) add(data[i]);
	}
	public void add(T data){
		if(root == null){
			root = new BstNode();
			root.data = data;
		}else{
			BstNode cur = root;
			BstNode prev = null;
			while (cur != null){
				prev = cur;
				if (comparator.compare(data, cur.data) > 0) cur = cur.right;
				else cur = cur.left;
			}			
			BstNode newNode = new BstNode();
			newNode.data = data;
			if (comparator.compare(data, prev.data) > 0) prev.right = newNode;
			else prev.left = newNode;
		}
	}
	public Iterator<T> getIterator(){ return new InorderIterator(); }
	public Iterator<T> getMorrisOrderIterator(){ return new MorrisInorderIterator(); }
	public void inorder(){
		inorderInternal(root);
	}
	public void iterativeInorder(){
		Stack<BstNode> stack = new Stack<BstNode>();
		BstNode cur = root;
		while (true){
			while (cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.empty()) break;
			BstNode temp = stack.pop();
			System.out.println(temp.data);
			cur = temp.right;
		}
	}
	public void morrisOrder(){
		BstNode cur = root;
		BstNode temp = null;
		while(cur != null){
			if (cur.left == null){
				System.out.println(cur.data);
				cur = cur.right;
			}else{
				temp = cur.left;
				while(temp.right != null && temp.right != cur){
					temp =temp.right;
				}
				if (temp.right == null){
					temp.right = cur;
					cur = cur.left;
				}else{
					System.out.println(cur.data);
					temp.right = null;
					cur = cur.right;
				}
			}
		}
	}
	public List<T> getCommonsWith(GenericBST<T> that){
		List<T> commons = new ArrayList<T>();
		getCommonElements(this.root, that.root, commons);
		return commons;
	}
	public List<T> getCommonsWithIterator(GenericBST<T> that){		
		Iterator<T> it1 = this.getIterator();
		Iterator<T> it2 = that.getIterator();
		return getCommonsWithIteratorInternal(it1, it2);
	}
	public List<T> getCommonsWithMorrisIterator(GenericBST<T> that){		
		Iterator<T> it1 = this.getMorrisOrderIterator();
		Iterator<T> it2 = that.getMorrisOrderIterator();
		return getCommonsWithIteratorInternal(it1, it2);
	}	
	private List<T> getCommonsWithIteratorInternal(Iterator<T> it1, Iterator<T> it2) {
		List<T> items = new ArrayList<T>();
		if (it1.hasNext() && it2.hasNext()) {
			T item1 = it1.next();
			T item2 = it2.next();		
			while(it1.hasNext() && it2.hasNext()){			
				if (comparator.compare(item1, item2) == 0){
					if(items.size() > 0){
						if (comparator.compare(items.get(items.size() - 1), item1) != 0) items.add(item1);
					}else {
						items.add(item1);
					}
					item1 = it1.next();
					item2 = it2.next();
				}else{
					if (comparator.compare(item1, item2) < 0) item1 = it1.next();
					else item2 = it2.next();
				}				
			}
			/*Check if the last two items are equals or not. We do not have a peek function in Iterator interface (We can write it though), therefore have to 
			 * do a next at the beginning of the loop to start with.*/
			if (comparator.compare(item1, item2) == 0){
				if(items.size() > 0){
					if (comparator.compare(items.get(items.size() - 1), item1) != 0) items.add(item1);
				}else {
					items.add(item1);
				}
			}
		}
		/*This is required, because in Morris Order traversal; we modify the tree structure and after 
		 * a whole traversal we get back the original tree. Therefore, this is required and not painful for runtime.*/
		while(it1.hasNext()) it1.next();
		while(it2.hasNext()) it2.next();		
		return items;
	}	
	private void inorderInternal(BstNode node){
		if (node == null) return;
		inorderInternal(node.left);
		System.out.println(node.data);
		inorderInternal(node.right);
	}
	private void getCommonElements(BstNode node1, BstNode node2, List<T> commons){
		if (node1 == null) return;	
		getCommonElements(node1.left, node2, commons);
		getCommonElementsInteral(node1, node2, commons);
		getCommonElements(node1.right, node2, commons);
	}	
	private void getCommonElementsInteral(BstNode node1, BstNode node2, List<T> commons){
		if (node2 == null) return;
		if (comparator.compare(node1.data, node2.data) < 0){
			node2 = node2.left;
			getCommonElementsInteral(node1, node2, commons);
		}else if (comparator.compare(node1.data, node2.data) == 0){
			if (commons.size() > 0){
				 if (commons.get(commons.size() - 1) != node1.data){
					 commons.add(node1.data);
				 }
			}else{
				commons.add(node1.data);
			}
		}else{
			node2 = node2.right;
			getCommonElementsInteral(node1, node2, commons);
		}
	}
	private class InorderIterator implements Iterator<T>{
		private Stack<BstNode> stack = new Stack<BstNode>();
		BstNode cur = root;
		public InorderIterator(){
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}
		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			BstNode temp = stack.pop();			
			cur = temp.right;
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}
			return temp.data;
		}
		@Override
		public void remove() {
		}
	}
	private class MorrisInorderIterator implements Iterator<T>{
		BstNode cur = root;
		BstNode temp = null;
		@Override
		public boolean hasNext() {
			return cur != null;
		}
		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			T data = null;
			while(data == null){
				if (cur.left == null){
					data =  cur.data;
					cur = cur.right;
				}else{
					temp = cur.left;
					while(temp.right != null && temp.right != cur){
						temp =temp.right;
					}
					if (temp.right == null){
						temp.right = cur;
						cur = cur.left;
					}else{
						data = cur.data;
						temp.right = null;
						cur = cur.right;
					}
				}
			}
			return data;
		}
		@Override
		public void remove() {
		}
	}
	
	public static void main(String[] args){		
		IntegerComparator cmp = new IntegerComparator();
		GenericBST<Integer> bst1 = new GenericBST<Integer>(cmp);
		bst1.addAll(new Integer[]{25,20,10,22,50,35,65});
		GenericBST<Integer> bst2 = new GenericBST<Integer>(cmp);
		bst2.addAll(new Integer[]{100,50,35,65,125,150,200});
		/*System.out.println("Recursive Inorder: ");
		bst1.inorder();
		System.out.println("Iterative Inorder: ");		
		bst1.iterativeInorder();
		System.out.println("Morris Inorder: ");		
		bst1.morrisOrder();*/
		
		System.out.println("Commons with Recursive");
		List<Integer> commons = bst1.getCommonsWithIterator(bst2);
		for (Integer common : commons){
			System.out.println(common);
		}		
	}
}
