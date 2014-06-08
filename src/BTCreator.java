import java.util.*;
public class BTCreator {	
	public <T> BTNode<T> createCompleteBinaryTree(List<T> data, int left, int right, BTNode<T> parent){
		if (left > right) return null;
		else{
			int mid = left + (right -left)/2;
			BTNode<T> node = new BTNode<T>(data.get(mid), null,null, parent);
			BTNode<T> leftNode = createCompleteBinaryTree(data, left, mid - 1, node);
			BTNode<T> rightNode = createCompleteBinaryTree(data, mid + 1, right, node);
			node.setLeft(leftNode);
			node.setRight(rightNode);			
			return node;
		}
	}
	public <T> void levelOrder(BTNode<T> root){
		if (root == null) return;
		Queue<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		queue.add(root);
		int cur = 1;
		int next = 0;
		while(queue.size() > 0){
			BTNode<T> node = queue.poll();			
			System.out.println(node.getData());
			cur --;
			if (node.getLeft() != null){
				queue.add(node.getLeft());
				next++;
			}
			if (node.getRight() != null){
				queue.add(node.getRight());
				next++;
			}			
			if (cur == 0){
				cur = next;
				next = 0;
				System.out.println();
			}
		}
	}
	public <T> BTNode<T> getNode(BTNode<T> root, T val){
		if (root == null) return null;
		if (root.getData().equals(val)) return root;
		/*if (getNode(root.getLeft(), val) != null;
		getNode(root.getRight(), val); */
		 BTNode<T> found = getNode(root.getLeft(), val);
		 if (found != null) return found;
		 else return getNode(root.getRight(), val);
	}
	public <T> List<T> pathToRoot(BTNode<T> node){
		if (node == null) return null;
		if (node.getParent() == null) {
			List<T> lst = new ArrayList<T>();
			lst.add(node.getData());
			return lst;
		}
		List<T> prev = pathToRoot(node.getParent());
		if (prev == null) return null;
		List<T> path = new ArrayList<T>();
		for (T itm : prev) path.add(itm);
		path.add(node.getData());
		return path;
	}
	
	public static void main(String[] args){
		BTCreator creator = new BTCreator();
		List<Integer> lst = new ArrayList<Integer>();
		lst.add(4);lst.add(2);lst.add(5);lst.add(1);lst.add(6);lst.add(3);
		BTNode<Integer> root = creator.createCompleteBinaryTree(lst, 0, lst.size() - 1, null);
		creator.levelOrder(root);
		
		BTNode<Integer> node = creator.getNode(root, 3);
		if (node == null) {
			System.out.println("Not found");
		}else{			
			List<Integer> path = creator.pathToRoot(node);
			System.out.println(path);		
		}		
	}
}
