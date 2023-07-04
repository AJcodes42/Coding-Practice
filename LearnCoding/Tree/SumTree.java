//https://practice.geeksforgeeks.org/problems/sum-tree/1

class Solution
{
	boolean isSumTree(Node root)
	{
	    //1st Approach O(N) time complexity and O(H) space complexity
	    
	   boolean ans[] = new boolean[1];
	   ans[0] = true;
        int lSum = 0;
	   int rSum = 0;
	   if(root.left != null) {
	       lSum = sumCalc(root.left,ans);
	   }
	   if(root.right != null) {
	       rSum = sumCalc(root.right,ans);
	   }
	   if(ans[0] && root.data != lSum+rSum) {
	       ans[0] = false;
	   } 
        
        return ans[0];
    
	}
	
	int sumCalc(Node node,boolean ans[]) {
	    
	    if(node.left == null && node.right == null) {
	        return node.data;
	    }
	    int lSum = 0;
	    int rSum = 0;
	    if(node.left != null) {
	        lSum = sumCalc(node.left,ans);
	    }
	    if(node.right != null) {
	        rSum = sumCalc(node.right,ans);
	    }
	    if(ans[0] && node.data != lSum+rSum) {
	        ans[0] = false;
	    } 
	    return node.data+lSum+rSum;
	}

}


class Solution
{
	boolean isSumTree(Node root)
	{
        // 2nd Approach O(N) time complexity and O(H) space complexity
        
        int ls = 0;
        int rs = 0;
        
        if(root == null || isLeaf(root)) {
            return true;
        }
        
        if(isSumTree(root.left) && isSumTree(root.right)) {
            if(root.left == null) {
                ls = 0;
            } else if(isLeaf(root.left)) {
                ls = root.left.data;
            } else {
                ls = 2*root.left.data;
            }
            
            if(root.right == null) {
                rs = 0;
            } else if(isLeaf(root.right)) {
                rs = root.right.data;
            } else {
                rs = 2*root.right.data;
            }
            
            if(root.data == ls+rs) {
                return true;
            } else return false;
        }
        
        return false;
	}

    boolean isLeaf(Node node) 
    {
        if (node == null)
            return false;
        if (node.left == null && node.right == null)
            return true;
        return false;
    }
}
