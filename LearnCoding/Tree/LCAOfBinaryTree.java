//Problem: https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-binary-tree/1

class Solution
{
    //Function to return the lowest common ancestor in a Binary Tree.
	Node lca(Node root, int n1,int n2)
	{
		if(root == null) {
		    return null;
		}
		
		if(root.data == n1 || root.data == n2) {
		    return root;
		}
		
		Node lLca = lca(root.left, n1, n2);
		Node rLca = lca(root.right, n1, n2);
		
		if(lLca != null && rLca != null) {
		    return root;
		}
		
		return (lLca != null ? lLca : rLca);
	}
}