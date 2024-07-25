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

       int ans[] =  {Integer.MAX_VALUE};
        int c[]={0};
        inorder(c, ans , root , K);
       return c[0] >= K ? ans[0] : -1;
    }
    
    void inorder(int c[] , int ans[] , TreeNode root , int k){
        if(root == null){
            return;
        }
        inorder(c, ans, root.left, k);
        c[0]++;
        if(c[0] == k){
            ans[0]=root.val;
        }
        inorder(c , ans , root.right, k);
 */
class Solution {
    public int kthSmallest(TreeNode root, int K) {
        int ans[] = {Integer.MAX_VALUE};
        int c[] =   new int[1];
        inorder(root, ans, c, K);
        if(ans[0] == Integer.MAX_VALUE){
            return -1;
        }
        return ans[0];
    }
    void inorder(TreeNode root , int ans[] , int c[] , int k){
        if(root == null){
            return ;
        }
        inorder(root.left, ans, c, k);
        c[0]++;
        if(c[0] == k){
            ans[0] = root.val;
        }
        inorder(root.right, ans, c, k);
    }
}