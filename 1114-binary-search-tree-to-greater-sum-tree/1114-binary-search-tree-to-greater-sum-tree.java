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
    public TreeNode bstToGst(TreeNode root) {
        /*
         ArrayList<Integer> arr = new ArrayList<>();
        
      
        inOrderTraversal(arr, root);
        
       
        for(int i = arr.size() - 2; i >= 0; i--) {
            arr.set(i, arr.get(i) + arr.get(i + 1));
        }
        
        
        inOrderTraversal2(arr, new int[]{0}, root);
        
        return root; 
        */
        int sum[] = new int[1];
       solve(root , sum);
       return root;
    }
      void solve(TreeNode root , int sum[]){
        if(root == null){
            return ;
        }
        solve(root.right , sum);
        sum[0]  += root.val;
        root.val = sum[0];
         solve(root.left , sum);
      }
    void inOrderTraversal(ArrayList<Integer> arr, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(arr, root.left);
        arr.add(root.val);
        inOrderTraversal(arr, root.right);
    }
    
    void inOrderTraversal2(ArrayList<Integer> arr, int[] index, TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal2(arr, index, root.left);
        root.val = arr.get(index[0]);
        index[0]++;
        inOrderTraversal2(arr, index, root.right);
    
    }
}