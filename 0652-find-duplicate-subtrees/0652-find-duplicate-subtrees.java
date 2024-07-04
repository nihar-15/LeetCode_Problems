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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        func(root , res , map);
        return res;
    }
    String func(TreeNode root , List<TreeNode> res , Map<String , Integer> map){

        if(root ==  null){
            return "N";
        }
        String s = Integer.toString(root.val)+","+ func(root.left , res , map )+","+ func(root.right, res , map);
        map.put(s, map.getOrDefault(s, 0) + 1);
        
        if (map.get(s) == 2) {
            res.add(root);
        }
        
      return s;
    }
}