class Solution {
    int finalAns = 0;

    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[piles.length][piles.length + 1][2];  
        return func(piles, 0, 0, 1, dp);
    }

    int func(int piles[], int idx, int turn, int m, int[][][] dp) {
        if (idx >= piles.length) {
            return 0;  // No more stones to take
        }

        if (dp[idx][m][turn] != 0) {  
            return dp[idx][m][turn];
        }

        int ans;
        int current = 0;

        if (turn == 0) {  // Alice's turn
            ans = Integer.MIN_VALUE;
            for (int x = 1; x <= 2 * m && idx + x - 1 < piles.length; x++) {
                current += piles[idx + x - 1];
                ans = Math.max(ans, current + func(piles, idx + x, 1, Math.max(m, x), dp));
            }
        } else {  // Bob's turn
            ans = Integer.MAX_VALUE;
            for (int x = 1; x <= 2 * m && idx + x - 1 < piles.length; x++) {
                current += piles[idx + x - 1];
                ans = Math.min(ans, func(piles, idx + x, 0, Math.max(m, x), dp));
            }
        }

        dp[idx][m][turn] = ans;
        return ans;
    }
}
