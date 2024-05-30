/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);

      
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddHead = odd;
        ListNode evenHead = even;
        
        
        ListNode temp = head;
        
       
        int index = 1;
        
        while (temp != null) {
           
            if (index % 2 != 0) {
                odd.next = temp;
                odd = odd.next;
            } else {
                even.next = temp;
                even = even.next;
            }
            temp = temp.next;
            index++;
        }
        
        odd.next = evenHead.next;
        // Terminate the even list
        even.next = null;

    
        return oddHead.next;
    }
}