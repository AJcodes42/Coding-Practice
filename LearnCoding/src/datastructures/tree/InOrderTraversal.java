package datastructures.tree;
import java.util.*;
public class InOrderTraversal {
	Node root;
	static class Node{
		Node left, right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void inorderTraversalIterative(Node root){
		Stack<Node> stack = new Stack<>();
		if(root == null) {
			return;
		}
		Node curr = root;
//		while(curr !=null || !stack.isEmpty()) {
//			while(curr != null) {
//				stack.push(curr);
//				curr = curr.left;
//			}
//		
//			
//			curr = stack.pop();
//			System.out.println(curr.data);
//				curr = curr.right;
//		
//		}
		
		//using 1 while loop
		
		while(curr !=null || !stack.isEmpty()) {
			if(curr != null) {
				stack.push(curr);
				curr = curr.left;
			} else {
				curr = stack.pop();
				System.out.println(curr.data);
				curr = curr.right;
			}
		
		}
		
	}
	public static void main(String[] args) {
		InOrderTraversal tree = new InOrderTraversal();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        
        inorderTraversalIterative(tree.root);
        // 4 2 5 1 3 
	}

}
