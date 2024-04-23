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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return fun(root , targetSum);
    }
    private boolean fun(TreeNode root , int targetSum){
     
        if(root == null){
            return false;
        }
        if(root.left==root.right){
            //targetSum -= root.val;
            return targetSum == root.val;
        }
        targetSum -= root.val;
        boolean t1 = fun(root.left, targetSum);
       // targetSum += root.val;
        boolean t2 = fun(root.right , targetSum );
       /// targetSum += root.val;
        return t1||t2;
    }
}