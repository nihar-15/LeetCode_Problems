class Solution {
    int cnt = 0 ;
    public int countGoodNodes(int[][] edges) {
        List<List<Integer>>  adj = new ArrayList<>();
        for(int i =0 ; i<=edges.length ; i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
      
       dfs(adj , 0 , -1);
        return cnt ;
    }
    int dfs(List<List<Integer>> adj , int node , int parent){
         int size =1 ; 
         Set<Integer> set = new HashSet<>();
         for(int a : adj.get(node)){
            if( a!= parent){
                int leaf = dfs(adj , a , node);
                size += leaf;
                set.add(leaf);
            }
         }
      if(set.size() <= 1){
        System.out.println(node);
        cnt++;
      }
      return size;
    }
}