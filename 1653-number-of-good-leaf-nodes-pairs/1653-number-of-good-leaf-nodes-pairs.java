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
    private void makeGraph(TreeNode current , TreeNode prev  ,  Map<TreeNode, List<TreeNode>> graph , Set<TreeNode> set){
        if(current == null ){
            return ;
        }
        if(current.left == current.right){
            set.add(current);
        }
        if(prev != null){
             graph.computeIfAbsent(prev, k -> new ArrayList<TreeNode>());
            graph.get(prev).add(current);
            graph.computeIfAbsent(current, k -> new ArrayList<TreeNode>());
            graph.get(current).add(prev);
        }

        makeGraph(current.left , current , graph , set);
        makeGraph(current.right , current, graph ,set);
    }
    public int countPairs(TreeNode root, int distance) {
    Map<TreeNode, List<TreeNode>> graph = new HashMap<>();
     Set<TreeNode> leafNodes = new HashSet<>();
     int count =0; 
     makeGraph(root , null , graph , leafNodes);
     for(TreeNode leaf : leafNodes){
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited= new HashSet<>();
        q.offer(leaf);
        visited.add(leaf);
        for(int level =0 ; level <= distance; level++){
            int size= q.size();
            for(int  j = 0 ; j< size; j++){
                TreeNode curr = q.poll();
                if(leafNodes.contains(curr) && curr != leaf){
                    count++;
                }
                if(graph.containsKey(curr)){
                  for(TreeNode neighbour : graph.get(curr)){
                    if(!visited.contains(neighbour)){
                        q.offer(neighbour);
                        visited.add(neighbour);
                    }
                  }
                }
            }
             
        }
     }
      return count/2;
     }
}
