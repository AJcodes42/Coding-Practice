package datastructures.tree;

import java.util.Stack;

import datastructures.tree.InOrderTraversal.Node;

public class PreOrderTraversal {
	Node root;
	static class Node{
		Node left, right;
		int data;
		Node(int data){
			this.data = data;
		}
	}
	
	public static void preorderTraversalIterative(Node root){
		Stack<Node> stack = new Stack<>();
		if(root == null) {
			return;
		}
		Node curr = root;
		stack.push(curr);
		while(!stack.isEmpty()) {
			curr = stack.pop();
			System.out.println(curr.data);
			if(curr.right != null) {
				stack.push(curr.right);
			}
			if(curr.left != null) {
				stack.push(curr.left);
			}
		}
	}
	public static void main(String[] args) {
		PreOrderTraversal tree = new PreOrderTraversal();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5);
        
        preorderTraversalIterative(tree.root);
        // 1 2 4 5 3 
	}
}
