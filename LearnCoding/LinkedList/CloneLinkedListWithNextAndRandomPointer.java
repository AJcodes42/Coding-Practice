//Problem: https://practice.geeksforgeeks.org/problems/clone-a-linked-list-with-next-and-random-pointer/1

class Clone {
    Node copyList(Node head) {
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }
        
        Node orgCurr = head;
        Node copyCurr = head.next;
        
        while(orgCurr != null) {
            if(orgCurr.arb != null) {
                copyCurr.arb = orgCurr.arb.next;
            }
            if(copyCurr.next != null) {
                copyCurr = copyCurr.next.next;
            }
            orgCurr = orgCurr.next.next;
        }
        orgCurr = head;
        copyCurr = head.next;
        Node cloneHead = head.next;
        while(orgCurr != null) {
            orgCurr.next = orgCurr.next.next;
            if(copyCurr.next != null) {
                copyCurr.next = copyCurr.next.next;
            }
            orgCurr= orgCurr.next;
            copyCurr = copyCurr.next;
        }
        
        return cloneHead;
    }
}
