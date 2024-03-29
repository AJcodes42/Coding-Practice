//Problem: https://practice.geeksforgeeks.org/problems/stack-using-two-queues/1

class Queues
{
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();
    
    //Function to push an element into stack using two queues.
    void push(int a)
    {
	    if(q1.isEmpty()) {
	        q1.add(a);
	    } else {
	        q2.add(a);
	        while(!q1.isEmpty()) {
	            q2.add(q1.remove());
	        }
	        Queue<Integer> temp = q1;
	        q1 = q2;
	        q2 = temp;
	    }
	    
    }
    
    //Function to pop an element from stack using two queues. 
    int pop()
    {
        if(q1.isEmpty()) {
            return -1;
        }
	    return q1.remove();
    }
	
}
