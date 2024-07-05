class Solution {
    public int findCircleNum(int[][] isConnected) {
     List<List<Integer>> adj = new ArrayList<>();
     int n = isConnected.length;
        for(int i =0;i < n;i++ ){
            adj.add(new ArrayList<>());
        }
        for(int i =0 ; i< n;i++){
            for( int j =0 ; j < n; j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
  for (int i = 0; i < adj.size(); i++) {
            System.out.print(i + ": ");
            for (Integer neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
     int count =0 ;
     boolean isVisited[] = new boolean[n];
     for(int i =0; i<n ;i++){
        if(!isVisited[i]){
            dfs(adj , i , isVisited);
            count++;
        }
     }
        return count;
    }
    void dfs( List<List<Integer>> adj , int i ,  boolean isVisited[]){
        isVisited[i] = true;
        for(Integer it : adj.get(i)){
            if(!isVisited[it]){
                dfs(adj , it , isVisited);
            }
        }
    }
}