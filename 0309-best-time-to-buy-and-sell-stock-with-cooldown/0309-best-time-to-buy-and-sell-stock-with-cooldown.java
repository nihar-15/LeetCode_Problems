class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
       return func(prices, 0 , 1, dp);
    }
      int func(int prices[], int day, int canBuy, int dp[][]) {
        if (day >= prices.length) {
            return 0;
        }

        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(-prices[day] + func(prices, day + 1, 0, dp), func(prices, day + 1, 1, dp));
        } else {
            profit = Math.max(prices[day] + func(prices, day + 2, 1, dp), func(prices, day + 1, 0, dp));
        }

        dp[day][canBuy] = profit;
        return profit;
}
}