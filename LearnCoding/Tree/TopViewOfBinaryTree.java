//Problem: https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class QueueObj {
        int hd;
        Node node;
        QueueObj(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
    static ArrayList<Integer> topView(Node root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        Map<Integer,Node> tmap = new TreeMap<>();
        Queue<QueueObj> queue = new LinkedList<>();
        
        if(root == null) {
            return ans;
        } else {
            queue.add(new QueueObj(0,root));
        }
        
        while(!queue.isEmpty()) {
            QueueObj temp = queue.poll();
            if(!tmap.containsKey(temp.hd)) {
                tmap.put(temp.hd,temp.node);
            }
            
            if(temp.node.left != null) {
                queue.add(new QueueObj(temp.hd-1,temp.node.left));
            }
            
            if(temp.node.right != null) {
                queue.add(new QueueObj(temp.hd+1,temp.node.right));
            }
        }
        
        for(Map.Entry<Integer,Node> entry : tmap.entrySet()) {
            ans.add(entry.getValue().data);
        }
        return ans;
        
    }
}