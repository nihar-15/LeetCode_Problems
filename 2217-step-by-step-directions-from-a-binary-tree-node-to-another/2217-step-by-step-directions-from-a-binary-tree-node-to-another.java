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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder pathToStartingNode = new StringBuilder();
        StringBuilder pathToEndingNode = new StringBuilder();
        findPath(root , startValue , pathToStartingNode);
        findPath(root , destValue , pathToEndingNode);
        //System.out.println(pathToStartingNode);
        String ans = "";
        int i = 0 , j =0 ;
        int m = pathToStartingNode.length();
        int n = pathToEndingNode.length();
         while (i < m && j < n && pathToStartingNode.charAt(i) == pathToEndingNode.charAt(j)) {
            i++;
            j++;
        }
        
        for (int k = i; k < m; k++) {
            ans += 'U';
        }
        
        for (int k = j; k < n; k++) {
            ans += pathToEndingNode.charAt(k);
        }
        
        return ans;
    }
   boolean findPath(TreeNode root, int value, StringBuilder path) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        
        path.append('L');
        if (findPath(root.left, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (findPath(root.right, value, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }

}