/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     int i;
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root , list);
        Collections.sort(list);
        i =0;
        func(root , list);

    }
    void inOrder(TreeNode root , ArrayList<Integer> list){
        if(root == null){
            return ;
        }
        inOrder(root.left , list);
        list.add(root.val);
        inOrder(root.right , list);
    }
     void func(TreeNode root , ArrayList<Integer> list){
        if(root == null){
            return ;
        }
        func(root.left , list);
        root.val = list.get(i);
        i++;
        func(root.right , list);
     }
}