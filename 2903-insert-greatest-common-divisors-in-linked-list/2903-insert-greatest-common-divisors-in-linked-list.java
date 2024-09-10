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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pointer = head;
        while(pointer.next != null){
            ListNode newNode = new ListNode(gcd(pointer.val , pointer.next.val) , pointer.next);
            pointer.next = newNode;
            pointer= newNode.next;
        }
        return head;
    }
    private int gcd(int a , int b){
        if(b == 0){
            return a;
        }
        return gcd(b , a%b);
    }
}