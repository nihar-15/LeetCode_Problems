/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    void markParents(TreeNode root , HashMap<TreeNode, TreeNode> parent){
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode current = q.poll();
            if(current.left != null){
                parent.put(current.left,current);
                q.offer(current.left);
            }
            if(current.right != null){
                parent.put(current.right,current);
                q.offer(current.right);
            }
        }
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode , TreeNode> parent= new HashMap<>();
        markParents(root,parent);
        Map<TreeNode, Boolean> vis= new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        vis.put(target , true);
        int cur_level=0;

        while(!q.isEmpty()){
            int size= q.size();
            if(cur_level == k) break;
            cur_level++;
            for(int i=0;i<size;i++){
                TreeNode cur= q.poll();
                if(cur.left != null && vis.get(cur.left)==null){
                    q.offer(cur.left);
                    vis.put(cur.left, true);
                }
                 if(cur.right != null && vis.get(cur.right)==null){
                    q.offer(cur.right);
                    vis.put(cur.right, true);
                }
                if(parent.get(cur) != null && vis.get(parent.get(cur))== null){
                    q.offer(parent.get(cur));
                    vis.put(parent.get(cur) , true);
                }
            }
        }
        List<Integer> ans= new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr =q.poll();
            ans.add(curr.val);
        }
       return ans;
    }
}