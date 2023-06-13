//Problem: https://practice.geeksforgeeks.org/problems/detect-loop-in-linked-list/1

class Solution {
    public static boolean detectLoop(Node head){
        Node slowPtr = head;
        Node fastPtr = head;
        
        while(slowPtr != null && fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(slowPtr == fastPtr) {
                return true;
            }
        }
        
        return false;
    }
}
