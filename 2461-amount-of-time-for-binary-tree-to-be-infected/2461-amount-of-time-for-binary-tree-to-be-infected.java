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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode , TreeNode> map = new HashMap<>();
        TreeNode strPtr = bfsToParents(root , start , map);
        return findMinTime(strPtr , map);
    }
    TreeNode bfsToParents(TreeNode root , int start,HashMap<TreeNode , TreeNode> map){
        Queue<TreeNode>  q = new LinkedList<>();
        q.add(root);
        TreeNode startPtr = null;
        while(q.isEmpty()!= true){
            TreeNode cur = q.poll();
            if(cur.val == start){
                startPtr = cur;
            }
            if(cur.left != null){
                map.put(cur.left , cur);
                q.add(cur.left);
            }
             if(cur.right != null){
                map.put(cur.right , cur);
                q.add(cur.right);
            }
        }
       return startPtr;
    }

    int findMinTime(TreeNode startPtr, HashMap<TreeNode ,TreeNode> map){
        HashSet<TreeNode> vis = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(startPtr);
        vis.add(startPtr);
        int time =0;
        while(!q.isEmpty()){
            boolean flag =false;
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left != null && !vis.contains(curr.left)){
                    q.add(curr.left);
                    vis.add(curr.left);
                    flag =true;
                }
                if(curr.right != null && !vis.contains(curr.right)){
                    q.add(curr.right);
                    vis.add(curr.right);
                    flag =true;
                }
                if(map.containsKey(curr) && !vis.contains(map.get(curr))){
                    q.add(map.get(curr));
                    vis.add(map.get(curr));
                    flag = true;
                }
            }
                 if(flag)
                time++;
            
                
        }
            return time;
        }
    }
