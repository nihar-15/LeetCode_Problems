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
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum=0;
        ArrayList<Integer> arr=new ArrayList<>();
      inOrder(arr,root);
      for(int i=0;i<arr.size();i++){
      	if(arr.get(i)>= low && arr.get(i)<=high){
            sum+=arr.get(i);
        }
      }
     return sum;
    }
    
   public static void inOrder(ArrayList<Integer> arr,TreeNode n){
	if(n==null){
		return;
	}

	inOrder(arr,n.left);
		System.out.println(arr.add(n.val));
    inOrder(arr,n.right);

        
    }
}