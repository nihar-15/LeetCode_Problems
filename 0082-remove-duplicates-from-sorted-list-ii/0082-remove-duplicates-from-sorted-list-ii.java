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
    public ListNode deleteDuplicates(ListNode head) {
       if (head == null) return null;

        HashMap<Integer, Integer> countMap = new HashMap<>();
        ListNode temp = head;

        while (temp != null) {
            countMap.put(temp.val, countMap.getOrDefault(temp.val, 0) + 1);
            temp = temp.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        temp = head;
        while (temp != null) {
            if (countMap.get(temp.val) == 1) {
                current.next = new ListNode(temp.val);
                current = current.next;
            }
            temp = temp.next;
        }

        return dummy.next;
    }
}