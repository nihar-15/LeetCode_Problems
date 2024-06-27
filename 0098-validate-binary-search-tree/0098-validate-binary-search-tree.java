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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();

      inOrder(arr,root);

      for(int i=0;i<arr.size()-1;i++){

      	if(arr.get(i+1)<=arr.get(i)){

      		return false;

      	}

      }

      return true;

    }

    

   public static void inOrder(ArrayList<Integer> arr,TreeNode n){

	if(n==null){

		return;

	}

	inOrder(arr,n.left);

		arr.add(n.val);

    inOrder(arr,n.right);

}
    }
