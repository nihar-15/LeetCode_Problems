class Solution {
    public int[][] updateMatrix(int[][] grid) {
        int  m = grid.length;
        int  n = grid[0].length;
        int ans[][] = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
         int vis[][] = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 0){
                    q.offer(new Pair(i , j , 0));
                    vis[i][j] =1;
                    ans[i][j] =0;
                }else{
                    vis[i][j ]= 0;
                }
            }
        }
       
        int dr[] ={0 , -1, 0, 1};
        int dc[] ={-1, 0 , 1, 0};
        while(!q.isEmpty()){
            Pair cur = q.poll();
            int row = cur.row;
            int col = cur.col;
            int dist = cur.dist;
            System.out.println(row+" "+col+" "+dist);
           ans[row][col] = dist;
            for(int i =0;i<4;i++){
                int newRow = row+ dr[i];
                int newCol = col + dc[i];
              if(isSafe(newRow, newCol, m , n) && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 1){
                   q.offer(new Pair(newRow , newCol , dist+1));
                   vis[newRow][newCol] =1 ;
                 // ans[newRow][newCol] = dist + 1;
              }
            }

        }
        return ans;
    }
    boolean isSafe( int i , int j ,int m , int n){
        if(i<0 || j<0|| i>=m ||j>= n){
            return false;
        }
        return true;
    }
}
class Pair{
    int row , col , dist;
    Pair(int r , int c , int d){
        row = r;
        col =c;
        dist = d;
    }
}