/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode current = head;

        if (current == null || current.next == null) {

            return head;

        }

        while (current.next != null) {

            if (current.next != null) {

                int data = current.val;

                current.val = current.next.val;

                current.next.val = data;

            }

            if (current.next.next != null) {

                current = current.next.next;

            } else {

                break;

            }

        }

        return head;

    }
}