//Problem: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list/1

class Solution
{
    //Function to reverse a linked list.
    Node reverseList(Node head)
    {
        Node prev = null,curr= head,next = null;
        
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}