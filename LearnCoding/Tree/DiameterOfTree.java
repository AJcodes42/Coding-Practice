//Problem: https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1

//Approach 1:
class Solution {
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        if(root == null) {
            return 0;
        }
        
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int diameter = lHeight+rHeight+1;
        
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        
        diameter = Math.max(diameter,lDiameter);
        diameter = Math.max(diameter,rDiameter);
        
        return diameter;
        
    }

    int height(Node root) {
        if(root == null) {
            return 0;
        }
        
        int leftH = height(root.left);
        int rightH = height(root.right);
        
        return Math.max(leftH,rightH)+1;
    }
    
    
}

//Approach 2 : refer GFG, in which height is calculated along with diameter

//Approach 3:
class Solution {
    // Function to return the diameter of a Binary Tree.
    int diameter(Node root) {
        
        int d[] = new int[1];
        heightWithDiameter(root,d);
        
        return d[0];
        
    }
    
    int heightWithDiameter(Node root, int[] d) {
        if(root == null) {
            d[0] = 0;
            return 0;
        }
        int ld[] = new int[1];
        int rd[] = new int[1];
        int leftH = heightWithDiameter(root.left,ld);
        int rightH = heightWithDiameter(root.right,rd);
        
        d[0] = Math.max(leftH+rightH+1,Math.max(ld[0],rd[0]));
        return Math.max(leftH,rightH)+1;
    }
    
}

