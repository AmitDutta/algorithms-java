import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class Bst {
	private class BstNode{
		private int data;
		private BstNode left;
		private BstNode right;
		public BstNode(int data, BstNode left, BstNode right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	private BstNode root;
	private List<Integer> commons;
	public Bst(){
		root = null;
		commons = new ArrayList<Integer>();
	}
	public void addAll(int[] data){
		for (int i = 0; i < data.length; i++) add(data[i]);
	}
	public void add(int data){
		if(root == null){
			root = new BstNode(data, null, null);
		}else{
			BstNode cur = root;
			BstNode prev = null;
			while (cur != null){
				prev = cur;
				if (data > cur.data) cur = cur.right;
				else cur = cur.left;
			}			
			BstNode newNode = new BstNode(data, null, null);
			if (data > prev.data) prev.right = newNode;
			else prev.left = newNode;
		}
	}
	public BstNode getRoot(){ return root; }
	public void inorder(BstNode node){
		if (node == null) return;
		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);
	}
	public void iterativeInorder(BstNode node){
		Stack<BstNode> stack = new Stack<BstNode>();
		BstNode cur = node;
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
	public void morrisOrder(BstNode node){
		BstNode cur = node;
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
	public List<Integer> getCommonsWith(Bst that){
		getCommonElements(this.getRoot(), that.getRoot());
		return commons;
	}
	public List<Integer> getCommonsWithIterator(Bst that){
		List<Integer> items = new ArrayList<Integer>();
		Iterator<Integer> it1 = this.getIterator();
		Iterator<Integer> it2 = that.getIterator();
		return getCommonsWithIteratorInternal(items, it1, it2);
	}
	public List<Integer> getCommonsWithMorrisIterator(Bst that){
		List<Integer> items = new ArrayList<Integer>();
		Iterator<Integer> it1 = this.getMorrisOrderIterator();
		Iterator<Integer> it2 = that.getMorrisOrderIterator();
		return getCommonsWithIteratorInternal(items, it1, it2);
	}
	private List<Integer> getCommonsWithIteratorInternal(List<Integer> items,
			Iterator<Integer> it1, Iterator<Integer> it2) {
		if (it1.hasNext() & it2.hasNext()) {
			int item1 = it1.next();
			int item2 = it2.next();		
			while(it1.hasNext() && it2.hasNext()){			
				if (item1 == item2){
					if(items.size() > 0){
						if (items.get(items.size() - 1) != item1) items.add(item1);
					}else {
						items.add(item1);
					}
					item1 = it1.next();
					item2 = it2.next();
				}else{
					if (item1 < item2) item1 = it1.next();
					else item2 = it2.next();
				}
			}
			/*Check if the last two items are equals or not. We do not have a peek function in Iterator interface (We can write it though), therefore have to 
			 * do a next at the beginning of the loop to start with.*/
			if (item1 == item2){
				if(items.size() > 0){
					if (items.get(items.size() - 1) != item1) items.add(item1);
				}else {
					items.add(item1);
				}
			}
		}
		/*This is required, because in Morris Order traverl; we modify the tree structure and after 
		 * a whole traversal we get back the original tree. Therefore, this is required and not painful for runtime.*/
		while(it1.hasNext()) it1.next();
		while(it2.hasNext()) it2.next();
		return items;
	}
	public Iterator<Integer> getIterator(){ return new InorderIterator(); }
	public Iterator<Integer> getMorrisOrderIterator(){ return new MorrisInorderIterator(); }
	private void getCommonElements(BstNode node1, BstNode node2){
		if (node1 == null) return;	
		getCommonElements(node1.left, node2);
		getCommonElementsInteral(node1, node2);
		getCommonElements(node1.right, node2);
	}	
	private void getCommonElementsInteral(BstNode node1, BstNode node2){
		if (node2 == null) return;
		if (node1.data < node2.data){
			node2 = node2.left;
			getCommonElementsInteral(node1, node2);
		}else if (node1.data == node2.data){
			if (commons.size() > 0){
				 if (commons.get(commons.size() - 1) != node1.data){
					 commons.add(node1.data);
				 }
			}else{
				commons.add(node1.data);
			}
		}else{
			node2 = node2.right;
			getCommonElementsInteral(node1, node2);
		}
	}
	private class InorderIterator implements Iterator<Integer>{
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
		public Integer next() {
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
	private class MorrisInorderIterator implements Iterator<Integer>{
		BstNode cur = getRoot();
		BstNode temp = null;
		@Override
		public boolean hasNext() {
			return cur != null;
		}

		@Override
		public Integer next() {
			if (!hasNext()) throw new NoSuchElementException();
			Integer data = null;
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
		Bst bst1 = new Bst();
		bst1.addAll(new int[]{25,20,10,22,50,35,65});	
		Bst bst2 = new Bst();
		bst2.addAll(new int[]{100,50,35,65,125,150,200});
		
		List<Integer> items = bst1.getCommonsWithMorrisIterator(bst2);
		for(Integer i : items) System.out.print(i + " ");
		System.out.println();
		
		items = bst1.getCommonsWithMorrisIterator(bst2);
		for(Integer i : items) System.out.print(i + " ");
		System.out.println();
	}
}
