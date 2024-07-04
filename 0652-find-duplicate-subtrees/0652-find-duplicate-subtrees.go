/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func findDuplicateSubtrees(root *TreeNode) []*TreeNode {
    res:= []*TreeNode{}
    mapCount := make(map[string]int)
    fun(root , &res , mapCount)
    return res
}
func fun(root *TreeNode , res*[]*TreeNode , mapCount map[string]int) string{
    if root == nil {
        return "N"
    }
    s:= strconv.Itoa(root.Val)+","+fun(root.Left, res, mapCount)+","+fun(root.Right, res, mapCount)
    mapCount[s]++
    if mapCount[s] == 2{
     *res = append(*res , root)
    }
    return s
}
