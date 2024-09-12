class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans[] = new int[n];
        int ball = 0;
        while (ball < n) {
            int i = 0;
            int j = ball;
            while (i < m ) {
                if (grid[i][j] == 1) {
                   if (j == n - 1 || (j < n-1 && grid[i][j + 1] == -1))  {
                        break;
                    }
                    j++;
                  
                } else{
                    if((j == 0 ||  (j > 0 &&  grid[i][j-1] == 1))) {
                        break;
                    }
                    j--;
                }
              i++;
            }
            if (i == m) {
                ans[ball] = j;
            } else {
                ans[ball] = -1;
            }
            ball++;
        }
        return ans;
    }
}