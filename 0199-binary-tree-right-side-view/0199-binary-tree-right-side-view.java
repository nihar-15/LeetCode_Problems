class Solution {
    public List<Integer> rightSideView(TreeNode root) {
    List<Integer>  ans = new ArrayList<>();
    if(root == null){
        return ans ;
    }
    Map<Integer, TreeNode> map = new TreeMap<>();
      Queue<TreeNode>  q = new LinkedList<>();
      q.offer(root);
      map.put(0 , root);
      while(!q.isEmpty()){
         TreeNode curr = q.poll();
         int level =0 ;
         for (Map.Entry<Integer, TreeNode> entry : map.entrySet()) {
                if (entry.getValue() == curr) {
                    level = entry.getKey();
                    break;
                }
            }
         if(curr.left != null){
            q.offer(curr.left);
            map.put(level - 1, curr.left);
         }
          if(curr.right != null){
            q.offer(curr.right);
            map.put(level + 1, curr.right);
         }
      }
      for(Integer key : map.keySet()){
        ans.add(map.get(key).val);
      }
      return ans ;
    }
}