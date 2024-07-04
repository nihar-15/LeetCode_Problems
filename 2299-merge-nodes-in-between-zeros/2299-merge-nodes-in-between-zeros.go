/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func mergeNodes(head *ListNode) *ListNode {
      dummy := &ListNode{Val :0}
      current := dummy
      temp:= head.Next
      sum:= 0

      for temp != nil{
        if temp.Val == 0{
            current.Next = &ListNode{Val:sum}
            current = current.Next
            sum = 0
        }else{
            sum += temp.Val
        }
        temp = temp.Next
      }

return dummy.Next

}
