/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null ){
            return "";
        }
        Queue<TreeNode> q = new LinkedList<>();
        String ans = "";
        q.add(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
           if(cur == null){
            ans += "n,";
           }else{
              ans += Integer.toString(cur.val);
              ans+= ",";
              q.add(cur.left);
              q.add(cur.right);
           }
        }
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == ""){
            return null;
        }
         StringBuilder s = new StringBuilder(data);
         int commaIndex = s.indexOf(",");
          String str = s.substring(0, commaIndex);
          s.delete(0, commaIndex + 1);
          TreeNode root = new TreeNode(Integer.parseInt(str));
          Queue<TreeNode> q = new LinkedList<>();
          q.offer(root);
          while(!q.isEmpty()){
            TreeNode node = q.poll();
            commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);

             if (!str.equals("n")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                q.offer(leftNode);
            }
             commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);

             if (!str.equals("n")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                q.offer(rightNode);
            }
          }

         return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));