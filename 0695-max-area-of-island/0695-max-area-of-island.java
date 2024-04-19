class Solution {
    public int maxAreaOfIsland(int[][] grid) {
   int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];

        int cnt=0;
        int max[] = new int[1];
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    int current[] ={1};
                    bfs(i , j , vis ,grid ,current);
                    max[0] =Math.max(max[0] ,current[0] );
                    cnt++;
                }
            }
        }
        return max[0];
        
    }
    static void bfs(int i , int j , int vis[][]  , int[][] grid ,int current[]){

        vis[i][j]=1;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i ,j));
         int m = grid.length;
        int n = grid[0].length;

        while(q.isEmpty() == false){
            int r = q.peek().f;
            int c = q.peek().s;
            q.poll();
            for(int dr =-1;dr<=1;dr++){
                for(int dc = -1;dc<=1;dc++){
                    int nr = r+dr;
                    int nc = c+dc;
                    if(isNeighbour(nr ,nc , r , c ,m ,n)== true && vis[nr][nc]== 0 && grid[nr][nc] ==1){
                        current[0]++;
                        vis[nr][nc]=1;
                        q.add(new Pair(nr , nc));
                        
                        System.out.println(current[0]);
                    }
                }
            }
        }

    }

   public static boolean isNeighbour(int nr, int nc, int r, int c, int m, int n) {
    return (nr >= 0 && nr < m && nc >= 0 && nc < n && (nr == r - 1 && nc == c || nr == r && nc == c + 1 || nr == r + 1 && nc == c || nr == r && nc == c - 1));
}


}


class Pair{

		int f,s;
		Pair(int fi,int se){
			this.f=fi;
			this.s=se;
		}

	}