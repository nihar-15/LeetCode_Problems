/**
 * Definition for a binary tree node.
 * type TreeNode struct {
 *     Val int
 *     Left *TreeNode
 *     Right *TreeNode
 * }
 */
func createBinaryTree(descriptions [][]int) *TreeNode {
    mapNode := make(map[int]*TreeNode)
    set := make(map[int]bool)
    
    for _, d := range descriptions {
        parent, child, isLeft := d[0], d[1], d[2]

        if _, exists := mapNode[parent]; !exists {
            mapNode[parent] = &TreeNode{Val: parent}
        }

        if _, exists := mapNode[child]; !exists {
            mapNode[child] = &TreeNode{Val: child}
        }

        if isLeft == 1 {
            mapNode[parent].Left = mapNode[child]
        } else {
            mapNode[parent].Right = mapNode[child]
        }

        set[child] = true
    }

    for _, d := range descriptions {
        parent := d[0]
        if !set[parent] {
            return mapNode[parent]
        }
    }

    return nil
}


