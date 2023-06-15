//Problem: https://practice.geeksforgeeks.org/problems/merge-sort-on-doubly-linked-list/1

class LinkedList
{
    static Node sortDoubly(Node head)
    {
        if(head == null || head.next == null) {
            return head;
        }
        Node mid = split(head);
        head = sortDoubly(head);
        mid = sortDoubly(mid);
        return merge(head,mid);
    }
    
    static Node split(Node head) {
        Node slow = head;
        Node fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node temp = slow.next;
        slow.next = null;
        return temp;
    }
    
    static Node merge(Node first, Node second) {
        if(first == null) {
            return second;
        }
        if(second == null) {
            return first;
        }
        
        if(first.data < second.data) {
            first.next = merge(first.next,second);
            first.next.prev = first;
            first.prev = null;
            return first;
        } else {
            second.next = merge(first,second.next);
            second.next.prev = second;
            second.prev = null;
            return second;
        }
    }
}