//Problem: https://practice.geeksforgeeks.org/problems/get-minimum-element-from-stack/1

class GfG
{
    int minEle;
    Stack<Integer> s;
    
    // Constructor    
    GfG()
	{
        s= new Stack<>();
	}
	
    /*returns min element from stack*/
    int getMin()
    {
	    if(!s.isEmpty()) {
	        return minEle;
	    } else {
	        return -1;
	    }
    }
    
    /*returns poped element from stack*/
    int pop()
    {
	    if(s.isEmpty()) {
	        return -1;
	    } else {
	        int temp = s.pop();
	        if(temp<minEle) {
	            int val = minEle;
	            minEle = 2*minEle-temp;
	            return val;
	        } else {
	            return temp;
	        }
	    }
    }

    /*push element x into the stack*/
    void push(int x)
    {
	    if(s.isEmpty())	{
	        s.push(x);
	        minEle = x;
	    } else if(minEle<=x) {
	        s.push(x);
	    } else {
	        int temp = 2*x-minEle;
	        s.push(temp);
	        minEle = x;
	    }
    }	
}
