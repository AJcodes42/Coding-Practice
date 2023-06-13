//Program: https://practice.geeksforgeeks.org/problems/intersection-point-in-y-shapped-linked-lists/1

class Intersect
{
    //Function to find intersection point in Y shaped Linked Lists.
	int intersectPoint(Node head1, Node head2)
	{
        int len1 = getCount(head1);
        int len2 = getCount(head2);
        int d = 0;
        int ans = -1;
        if(len1>=len2) {
            d = len1-len2;
            ans = getIntersectionPoint(head1, head2, d);
        } else {
            d = len2-len1;
            ans = getIntersectionPoint(head2, head1,d);
        }
        
        return ans;
        
	}
	
	int getIntersectionPoint(Node head1, Node head2,int d) {
	    while(d>0) {
	        head1 = head1.next;
	        d--;
	    }
	    
	    while(head1!= null && head2 != null) {
	        if(head1 == head2) {
	            return head1.data;
	        }
	        head1 = head1.next;
	        head2 = head2.next;
	    }
	    
	    return -1;
	}
	
	int getCount(Node head) {
	    int count = 0;
	    while(head != null) {
	        head = head.next;
	        count++;
	    }
	    return count;
	}
}