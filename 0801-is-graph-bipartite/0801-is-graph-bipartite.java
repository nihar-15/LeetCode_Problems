class Solution {
    public boolean isBipartite(int[][] graph) {
        int v = graph.length;
        int vis[] = new int[v+1];
        Arrays.fill(vis , -1);

      for(int i =0;i<v ;i++){
          if(vis[i] == -1){
                if (dfs(graph, vis , i , 0) == false){
                    return false;
                }
          }
      }
        return true;
    }
    boolean dfs(int graph[][] ,int vis[] , int parent , int colour ){
        vis[parent] =  colour;
      System.out.println("Node "+ parent +" "+colour);
        for(Integer node : graph[parent]){
            if(vis[node] == -1 ){
                if(dfs(graph , vis , node , 1 - colour ) == false){
                    return false;
                }
                }else if(vis[node] == vis[parent]){
                    return false;
            }
        }
        return true;
    }
}