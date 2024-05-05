import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = head;

        while (temp != null) {
            while (!stack.isEmpty() && temp.val > stack.peekLast().val) {
                stack.pollLast();
            }
            stack.addLast(temp);
            temp = temp.next;
        }

        ListNode head2 = null;
        ListNode tail = null;

        while (!stack.isEmpty()) {
            ListNode node = stack.pollFirst();
            if (head2 == null) {
                head2 = node;
                tail = node;
            } else {
                tail.next = node;
                tail = tail.next;
            }
        }

        if (tail != null) {
            tail.next = null;
        }

        return head2;
    }
}
