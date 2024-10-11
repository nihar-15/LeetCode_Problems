
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        int[] directions = {-1, 0, 1};
        
        PriorityQueue<Pair> q = new PriorityQueue<>();
        int[][] vis = new int[n][n];
        q.offer(new Pair(0, 0, 1));
        vis[0][0] = 1;
        
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int row = curr.i;
            int col = curr.j;
            int dis = curr.dis;

            if (row == n - 1 && col == n - 1) {
                return dis;
            }

           
            for (int i : directions) {
                for (int j : directions) {
                    if (i == 0 && j == 0) continue;

                    int newRow = row + i;
                    int newCol = col + j;

                    if (newRow >= 0 && newCol >= 0 && newRow < n && newCol < n && vis[newRow][newCol] == 0 && grid[newRow][newCol] == 0) {
                        vis[newRow][newCol] = 1;
                        q.offer(new Pair(newRow, newCol, dis + 1)); 
                    }
                }
            }
        }
        
        
        return -1;
    }
}

class Pair implements Comparable<Pair> {
    int i, j, dis;

    Pair(int i, int j, int d) {
        this.i = i;
        this.j = j;
        this.dis = d;
    }

    public int compareTo(Pair p) {
        return Integer.compare(this.dis, p.dis);
    }
}
