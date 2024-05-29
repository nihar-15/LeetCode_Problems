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

    ListNode getMiddle(ListNode head ){
        ListNode slow=head;

		ListNode fast=head.next;

		while(fast!=null&&fast.next!=null){

			slow=slow.next;

			fast=fast.next.next;

		}

		return slow;
    }
    public ListNode sortList(ListNode head) {
        
         return  mergeSort(head);

        }
       ListNode mergeSort(ListNode  head){
         if(head == null || head.next == null){
            return head;
         }
         ListNode mid = getMiddle(head);
         ListNode nextToMid =  mid.next;
         mid.next = null ;


         ListNode left = mergeSort(head);
         ListNode right = mergeSort(nextToMid);
     
         System.out.println(left.val +"  " + right.val);
         ListNode sortedList =   mergeTwoLists(left , right);
         return  sortedList ;
        
       }
       public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head =  new ListNode(-99999);
        ListNode cur = head;
        
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
               cur.next = list1;
               list1 = list1.next;
            }else{
               cur.next = list2;
               list2 = list2.next; 
            }
            cur = cur.next;
        }
        if(list1 != null){
            cur.next = list1;
            list1 = list1.next;
             cur = cur.next;
        }
         while(list2 != null){
            cur.next = list2;
            list2 = list2.next;
             cur = cur.next;
        }
        return head.next;
    }
}