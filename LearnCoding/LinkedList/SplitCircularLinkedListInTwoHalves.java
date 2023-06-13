//Problem: https://practice.geeksforgeeks.org/problems/split-a-circular-linked-list-into-two-halves/1

class gfg
{
        // Function  to split a circular LinkedList
	    void splitList(circular_LinkedList list)
        {
             //DO NOT REMOVE THESE 3 LINES
             Node head=list.head;
             Node head1=null;
             Node head2=null;
             
             //Modify these head1 and head2 here, head is the starting point of our original linked list.    
             Node slowPtr = head;
             Node fastPtr = head;

             while(fastPtr.next != head && fastPtr.next.next != head) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next.next;
             }
             if(fastPtr.next != head) {
                fastPtr = fastPtr.next;
             }

             head1 = fastPtr.next;
             fastPtr.next = slowPtr.next;
             head2 = slowPtr.next;
             slowPtr.next = head1;

             
             //DO NOT REMOVE THESE 2 LINES
             list.head1=head1;
             list.head2=head2;
	 }
}