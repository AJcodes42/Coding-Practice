//Problem: https://practice.geeksforgeeks.org/problems/pairwise-swap-elements-of-a-linked-list-by-swapping-data/1

public class Solution {
    //Approach 1: Using three pointers i.e prev, curr,next
    public Node pairwiseSwap(Node head)
    {
        if(head == null || head.next == null) {
            return head;
        }
        Node prev = head;
        Node curr = head.next;
        head = curr;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            if(next == null || next.next == null) {
                prev.next = next;
                break;
            }
            prev.next = next.next;
            
            prev = next;
            curr = prev.next;
        }
        
        return head;
    }

    //Approach 2: using two pointers i.e curr,next
    public Node pairwiseSwap(Node head)
    {
        Node newHead = head,next,curr=head;
        if(curr.next != null) {
            newHead = curr.next;
        }
        while(curr != null && curr.next != null) {
            next = curr.next.next;
            curr.next.next = curr;
            if(next != null && next.next != null) {
                curr.next = next.next;
            } else {
                curr.next = next;
            }
            curr = next;
        }
        
        return newHead;
    }
}
