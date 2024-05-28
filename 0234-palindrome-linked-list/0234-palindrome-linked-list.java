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
    public boolean isPalindrome(ListNode head) {
        
       StringBuilder traversal = new StringBuilder();

        while(head!=null){
            traversal.append(head.val);
            head=head.next;
        }
        System.out.println(traversal);
        return traversal.toString().equals(traversal.reverse().toString());
    }
}