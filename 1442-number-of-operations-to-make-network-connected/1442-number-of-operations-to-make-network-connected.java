class Solution {
    public int makeConnected(int n, int[][] connections) {
        int e = connections.length;
        if (e < n-1){
            return -1;
        }
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i< n ; i++){
            adj.add( new ArrayList<>());
        }
        boolean isVisited[] = new boolean[n];
        int connectedComponents = 0;
        for(int[]edge : connections){
            adj.get(edge[0]).add(edge[1]);
             adj.get(edge[1]).add(edge[0]);
        }
        for(int i =0 ; i< n ; i++){
            if(!isVisited[i]){
                dfs(adj , i , isVisited);
                connectedComponents ++;
            }
        }
        return connectedComponents - 1;
    }

    void dfs( List<List<Integer>> adj , int i , boolean[] isVisited){
        isVisited[i] = true;
        for(int a : adj.get(i)){
            if(!isVisited[a]){
                dfs(adj , a , isVisited);
            }
        }
    }
}