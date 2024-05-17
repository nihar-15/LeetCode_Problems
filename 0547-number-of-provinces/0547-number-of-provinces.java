class Solution {
    public int findCircleNum(int[][] isConnected) {
       /* ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int m= isConnected.length;
        int n = isConnected[0].length;
        for(int i = 0;i<m;i++){
            adj.add(new ArrayList<>());
        }
        int cnt = 0;
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                 if(isConnected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                 }
            }
        }
        int vis[] = new int[m];
        for(int i =0;i<m;i++){
            if(vis[i] == 0 ){
                  dfs(adj , i , vis);
                  cnt++;
            }
        }
        return cnt;
        */
        int n = isConnected.length;
        int numberOfComponents = 0;
        boolean[] visit = new boolean[n];
        for(int i =0;i<n ;i++){
            if(visit[i] == false){
                 numberOfComponents++;
                bfs(i , isConnected ,visit);
            }
        }
        
            return  numberOfComponents ;
    }
     private void bfs(int node , int[][] isConnected , boolean[] visit){
         Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        visit[node] = true;
        while(!q.isEmpty()){
            node = q.poll();
            for(int i =0;i<isConnected.length;i++){
                if(isConnected[node][i] == 1 && ! visit[i]){
                    q.offer(i);
                    visit[i] = true;
                }
            }
        }
     }

    
    private void  dfs(ArrayList<ArrayList<Integer>> adj , int node, int vis[]){
        vis[node] = 1;
        for(int neighbour : adj.get(node)){
            if(vis[neighbour] == 0){
            dfs(adj , neighbour , vis);
            }
        }
    }
    }
