class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;
        boolean[][] vis = new boolean[m][n];
        int[][] ans = new int[m][n];
        int[] dr = {0, -1, 0, 1};
        int[] dc = {-1, 0, 1, 0};
        Queue<Pair> q = new LinkedList<>();

    
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new Pair(i, j));
                    vis[i][j] = true;
                    ans[i][j] = 0; 
                }
            }
        }

        
        while (!q.isEmpty()) {
            Pair p = q.poll();
            int row = p.i;
            int col = p.j;

            for (int i = 0; i < 4; i++) {
                int nrow = row + dr[i];
                int ncol = col + dc[i];
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !vis[nrow][ncol]) {
                    ans[nrow][ncol] = ans[row][col] + 1;
                    vis[nrow][ncol] = true;
                    q.offer(new Pair(nrow, ncol));
                }
            }
        }

        return ans;
    }
}

class Pair {
    int i, j;
    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
