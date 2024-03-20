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
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> arr= new ArrayList<Integer>();
       inorder(root,arr);
        return arr;
    }
    
    public static void inorder(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
            }
          arr.add(root.val);
        inorder(root.left,arr);
      
        inorder(root.right,arr);
    }
}