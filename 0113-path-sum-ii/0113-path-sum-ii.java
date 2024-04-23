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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        fun(ans , new ArrayList<>() , root , targetSum);
        return ans;
    }
      void fun(List<List<Integer>> ans , List<Integer> path , TreeNode root , int targetSum){
        if(root== null){
            return;
        }
        path.add(root.val);
        targetSum -= root.val;
        if(root. left == root.right && targetSum ==0){
          ans.add(new ArrayList<>(path));
            }
       
      
        fun(ans ,path , root.left ,targetSum );
        fun(ans , path , root.right ,targetSum );
             path.remove(path.size()-1);
           return ;
      }
}