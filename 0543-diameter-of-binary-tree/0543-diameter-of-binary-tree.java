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
    public int diameterOfBinaryTree(TreeNode root) {
     int d[] = new int[1];
     find(root  , d);
     return d[0];   
    }
    int find(TreeNode root ,int d[]){
        if(root == null){
            return 0 ;
        }
        int lh[]= new int[1];
        int rh[] = new int[1];
        lh[0] = find(root.left, d);
        rh[0] = find(root.right , d);

        d[0]= Math.max(d[0] , lh[0]+rh[0]);
        return 1+ Math.max(lh[0], rh[0]);
    }
}