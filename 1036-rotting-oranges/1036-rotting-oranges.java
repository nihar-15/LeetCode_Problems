class Solution {
    public int orangesRotting(int[][] grid) {
          int m = grid.length;
        int n = grid[0].length;
        boolean vis[][] = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        
        // Enqueue all initially rotten oranges
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }
        
        int dr[] = {0, -1, 0, 1};
        int dc[] = {-1, 0, 1, 0};
        int maxTime = 0;
        
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            int row = cur.r;
            int col = cur.c;
            int time = cur.time;
            maxTime = Math.max(maxTime, time);
            
            for (int i = 0; i < 4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (isSafe(r, c, m, n) && !vis[r][c] && grid[r][c] == 1) {
                    q.offer(new Pair(r, c, time + 1));
                    vis[r][c] = true;
                    grid[r][c] = 2; // Mark the orange as rotten
                }
            }
        }
        
        // Check if there's any fresh orange left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        
        return maxTime;
    }
    
    private boolean isSafe(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}

class Pair {
    int r, c, time;
    Pair(int i, int j, int t) {
        r = i;
        c = j;
        time = t;
    }
}