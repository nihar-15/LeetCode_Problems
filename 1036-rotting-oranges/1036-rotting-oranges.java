class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int ans=0;
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];
        for(int i  =0;i<m ;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i , j , 0));
                }
            }
        }
        int dr[] = {-1, 0 , 1,0};
        int dc[] = {0 , 1 , 0 ,-1};
        while(!q.isEmpty()){
            Pair  cur = q.poll();
            int row = cur.row ;
            int col = cur.col;
            int time = cur.time;
            ans = Math.max(ans , time);
            for(int i =0;i<4;i++){        
                    int newRow = row +dr[i];
                    int newCol = col +dc[i];

                    if(isSafe(newRow , newCol , m , n) && grid[newRow][newCol] == 1 && vis[newRow][newCol] != 2){
                        q.add( new Pair(newRow , newCol , time+1));
                        vis[newRow][newCol] = 2;
                    }
                
            }

        }

        for(int i =0;i<m;i++){
        for(int j =0;j<n;j++){
            if(grid[i][j] == 1 && vis[i][j] != 2){
                return -1;
            }
        }
        }
        return ans;
    }

    private boolean isSafe(int i , int j , int m , int n){
        if(i>= m || i<0|| j>=n || j<0){
            return false;
        }
        return true;
    }
}

class Pair{
    int row , col , time;
    Pair(int r , int c , int t){
        row = r;
        col =c;
        time =t;
    }
}