class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean isVisited[] = new boolean[n];
        int cnt =0; 
        for(int i =0 ; i < stones.length ; i++){
          if(!isVisited[i]){
            dfs(stones , i , isVisited);
            cnt++;
          }
        }
        return n -cnt ;
    }
    void dfs(int stones[][] , int j , boolean isVisited[]){
        isVisited[ j ] = true;
        for(int i =0 ; i<stones.length; i++){
            int c= stones[ j ][1];
            int r =  stones[j][0];
            if((stones[i][0] == r || stones[i][1] == c ) && !isVisited[i]){
                dfs(stones , i , isVisited);
            }
        }
    }
}