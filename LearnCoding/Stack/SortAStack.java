//Problem: https://practice.geeksforgeeks.org/problems/sort-a-stack/1

class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		if(!s.isEmpty()) {
		    int temp = s.pop();
		    sort(s);
		    sortedInsert(s,temp);
		}
		return s;
		
	}
	
	public void sortedInsert(Stack<Integer> s,int temp) {
	    if(s.isEmpty() || s.peek()<=temp) {
	        s.push(temp);
	    } else {
	        int val = s.pop();
	        sortedInsert(s,temp);
	        s.push(val);
	    }
	}
}
