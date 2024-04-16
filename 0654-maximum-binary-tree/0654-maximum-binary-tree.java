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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
      int n = nums.length;
      TreeNode root = construct(nums , 0 , n-1);
      return root;
   }
   TreeNode construct(int []nums , int start , int end){
    if(start >end)  return null;
    if( start == end){
        return new TreeNode(nums[start]);
    }
    int idx = findMax(nums , start , end);
    TreeNode root = new TreeNode(nums[idx]);
    root.left = construct(nums, start , idx-1);
    root.right  = construct(nums , idx+1 , end);

    return root;
   }

    int findMax(int arr[] , int start , int end){
         int max = Integer.MIN_VALUE;
        int idx = -1;
        for(int i =start; i <=end; i++){
            if(arr[i] >  max){
                max = arr[i];
                idx = i; 
            }
        }
        
        return idx;
    }
}