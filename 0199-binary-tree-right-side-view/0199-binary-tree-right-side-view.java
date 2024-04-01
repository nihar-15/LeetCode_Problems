class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<TreeNode> q=new LinkedList();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode a=q.poll();
                temp.add(a.val);
                if(a.left!=null){
                    q.add(a.left);
                }
                if(a.right!=null){
                    q.add(a.right);
                }
            }
            Collections.reverse(temp);
            ans.add(temp.get(0));
        }
        return ans;
    }
}