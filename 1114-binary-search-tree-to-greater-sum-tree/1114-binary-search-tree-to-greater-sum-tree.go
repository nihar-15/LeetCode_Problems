/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func bstToGst(root *TreeNode) *TreeNode {
    arr := [] int{}
    inOrderTraversal(&arr , root)
    for i := len(arr) -2 ;i>= 0;i--{
        arr[i] = arr[i]+ arr[i+1]
    }
   index := 0
   inOrderTraversal2(arr, &index, root)
    return root
}

func inOrderTraversal(arr *[]int , root *TreeNode){
    if root == nil{
        return
    }
    inOrderTraversal(arr, root.Left)
    *arr = append(*arr, root.Val)
    inOrderTraversal(arr, root.Right)
}

func inOrderTraversal2(arr []int, index *int, root *TreeNode) {
    if root == nil {
        return
    }
    inOrderTraversal2(arr, index, root.Left)
    root.Val = arr[*index]
    *index++
    inOrderTraversal2(arr, index, root.Right)
}