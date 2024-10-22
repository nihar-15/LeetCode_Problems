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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> ans =  new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
          int size = q.size();
          long sum = 0;
          for(int  i = 0 ; i < size ; i++){
           TreeNode a = q.poll();
            sum+= a.val;
            if(a .left != null){
                q.offer(a.left);
            }
            if(a.right != null){
                q.offer(a.right);
            }
          }
          ans.add(sum);
        }

        if(ans.size() < k){
            return -1;
        }
        Collections.sort(ans);
        return ans.get(ans.size() - k);
    }
}