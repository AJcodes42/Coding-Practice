//Problem: https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1

class Solution{
    //Function to return list containing elements of right view of binary tree.
    ArrayList<Integer> rightView(Node node) {
        // Recursive solution
        
        // ArrayList<Integer> ans = new ArrayList<>();
        
        // rightViewUtil(node, 0, ans);
        
        // return ans;
        
        
        //Iterative Solution
        
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(node);
        queue.add(null);
        //int size = 0;
        while(!queue.isEmpty()) {
            
            Node temp = queue.peek();
            if(temp == null) { // This condition happens at end of tree
                break;
            }
            ans.add(temp.data);
            //size = queue.size();
            while(queue.peek() != null) {
                
                temp = queue.remove();
                if(temp.right != null) {
                    queue.add(temp.right);
                }
                if(temp.left != null) {
                    queue.add(temp.left);
                }
            }
            queue.remove();
            queue.add(null);
            
        }
        return ans;
    }
    
    public void rightViewUtil(Node node, int level, ArrayList<Integer> ans) {
        
        if(node == null) {
            return;
        }
        
        if(ans.size()<level+1) {
            ans.add(node.data);
        }
        
        if(node.right != null) {
            rightViewUtil(node.right, level+1, ans);
        }
        
        if(node.left != null) {
            rightViewUtil(node.left, level+1, ans);
        }
        
    }
}
