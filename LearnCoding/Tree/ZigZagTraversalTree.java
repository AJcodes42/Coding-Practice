//Problem: https://practice.geeksforgeeks.org/problems/level-order-traversal-in-spiral-form/1

//Approach 1: Recursive TC:O(N^2)
class Spiral
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        int h = height(root);
        boolean clockwise = false;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=1; i<=h; i++) {
            printLevel(root,i,clockwise,ans);
            clockwise = !clockwise;
        }
        
        return ans;
    }
    
    void printLevel(Node root, int level,boolean clockwise, ArrayList<Integer> ans) {
        if(root == null) {
            return;
        }
        
        if(level == 1) {
            ans.add(root.data);
        } else {
            if(clockwise) {
                printLevel(root.left,level-1,clockwise,ans);
                printLevel(root.right,level-1,clockwise,ans);
            } else {
                printLevel(root.right,level-1,clockwise,ans);
                printLevel(root.left,level-1,clockwise,ans);
            }
        }
    }
    
    int height(Node root) {
        if(root == null) {
            return 0;
        }
        
        return 1+Math.max(height(root.left),height(root.right));
    }
}


//Approach2: Using Stack and Queue TC: O(N)
class Spiral2
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
          
          ArrayList<Integer> list = new ArrayList<>();
          Stack<Node> s = new Stack<>();
          Queue<Node> q = new LinkedList<>();
          boolean clockwise = true;
          if(root == null) {
              return list;
          }
           
          s.add(root);
          list.add(root.data);
          while(!s.isEmpty()) {
              int size = s.size();
              while(size>0){
                    Node temp = s.pop();
                    if(clockwise) {
                        if(temp.left != null) {
                            q.add(temp.left); 
                            list.add(temp.left.data);
                        }
                        if(temp.right != null) {
                            q.add(temp.right);
                            list.add(temp.right.data);
                        }
                    } else {
                        if(temp.right != null) {
                            q.add(temp.right);
                            list.add(temp.right.data);
                        }
                        if(temp.left != null) {
                            q.add(temp.left); 
                            list.add(temp.left.data);
                        }
                    }
                    size--;
              }
               
              while(!q.isEmpty()) {
                  s.add(q.poll());
              }
              clockwise = !clockwise;
          }
           
          return list;
    }
}

//Approach 3: using two Stacks TC: O(N)
class Spiral2
{
    //Function to return a list containing the level order 
    //traversal in spiral form.	
    ArrayList<Integer> findSpiral(Node root) 
    {
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();
        s1.push(root);
        ArrayList<Integer> ans = new ArrayList<>();
 
        while (!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                Node temp = s1.peek();
                s1.pop();
                ans.add(temp.data);
 
                if (temp.right != null)
                    s2.push(temp.right);
 
                if (temp.left != null)
                    s2.push(temp.left);
            }
 
            while (!s2.empty()) {
                Node temp = s2.peek();
                s2.pop();
                ans.add(temp.data);
 
                if (temp.left != null)
                    s1.push(temp.left);
                if (temp.right != null)
                    s1.push(temp.right);
            }
        }
        
        return ans;
    }
}


