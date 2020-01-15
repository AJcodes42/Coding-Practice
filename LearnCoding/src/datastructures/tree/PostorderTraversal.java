package datastructures.tree;

import java.util.Stack;


public class PostorderTraversal {
	Node root;
	static class Node{
		Node left, right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void postorderTraversalIterative(Node root){
		Stack<Node> stack = new Stack<>();
		if(root == null) {
			return;
		}
		Node curr = root;
		while(curr!= null || !stack.isEmpty()) {
			while(curr!= null) {
				stack.push(curr);
				curr = curr.left;
			}
			Node temp;
			temp = stack.peek();
			
			if(temp.right !=null) {
				curr = temp.right;
			} else {
				System.out.println(temp.data);
				stack.pop();
				if(stack.peek().right == temp) {
					temp = stack.pop();
					System.out.println(temp.data);
				}
			}
			
		}
	}
	
	public static void main(String[] args) {
		PostorderTraversal tree = new PostorderTraversal();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        
        postorderTraversalIterative(tree.root);
        // 4 5 2 3 1
	}
	
}
