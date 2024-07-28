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
class BSTIterator {
   Stack<TreeNode > stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        this.pushAll(root);
    }
    
    public int next() {
        TreeNode ans = stack.pop();
        this.pushAll(ans.right);
        return ans.val;
    }
    
    public boolean hasNext() {
        return  !stack.isEmpty();
    }
    private void pushAll(TreeNode root){
        for(; root!= null ; root= root.left){
            stack.push(root);
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */