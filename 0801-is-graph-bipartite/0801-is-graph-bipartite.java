class Solution {
    public boolean isBipartite(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m = graph.length ;
        for(int i = 0 ; i < m ; i++ ){
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.add(new ArrayList<>());
            for (int j : graph[i]) {
                adj.get(i).add(j);
            }
        }
        int isColoured[] = new int[m];
        Arrays.fill(isColoured , -1);
        for(int i = 0 ; i < m ; i++){
            if(isColoured[i] == -1){
                boolean ans = dfs(adj , i , isColoured , 0);
                if(ans == false ){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj , int i , int isColoured[] , int colour){
        isColoured[i] = colour;
        for(int child : adj.get(i)){
          if(isColoured[child] == -1){
            if(dfs(adj , child , isColoured , 1 - colour ) == false){
                return false;
            }
            }else if(isColoured[child] == colour){
                return false;
            }
          }
    
        return true;
    }
}