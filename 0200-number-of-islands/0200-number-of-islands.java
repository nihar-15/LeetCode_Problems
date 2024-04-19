class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int vis[][] = new int[m][n];

        int cnt=0;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(vis[i][j] == 0 && grid[i][j] =='1'){
                    bfs(i , j , vis ,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
    static void bfs(int i , int j , int vis[][]  , char[][] grid){

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
                    if(isNeighbour(nr ,nc , r , c ,m ,n)== true && vis[nr][nc]== 0 && grid[nr][nc] =='1'){
                        vis[nr][nc]=1;
                        q.add(new Pair(nr , nc));
                    }
                }
            }
        }

    }

    	public static boolean isNeighbour(int nr,int nc,int r,int c,int m,int n){

		

		if(nr==r-1&&nc==c||nr==r&&nc==c+1||nr==r+1&&nc==c||nr==r&&nc==c-1){
            if(nr>=0&&nr<m&&nc>=0&&nc<n){
			return true;
		}
            }
		return false;

}
}


class Pair{

		int f,s;
		Pair(int fi,int se){
			this.f=fi;
			this.s=se;
		}

	}