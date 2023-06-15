// Problem: https://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1

class Solution
{
    public static Node reverse(Node node, int k)
    {
        Node head = node;
        int index = 1;
        
        if(head == null) {
            return null;
        }
        while(index<k) {
            head = head.next;
            if(head == null) {
                System.out.println("k should not be greater than length"); 
            }
            index++;
        }
        
        Node prev = null;
        Node curr = node;
        Node next = null;
        Node hangNode = curr;
        Node joinNode = null;
        
        while(curr != null) {
            index = 1;
            hangNode = curr;
            prev = null; //edgecase
            while(curr != null && index <= k){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                index++;
            }
            if(joinNode != null) {
                joinNode.next = prev;
            }
            
            joinNode = hangNode;
        }
        
        
        return head;

        
    }
}