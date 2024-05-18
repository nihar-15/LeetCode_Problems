import java.util.Arrays;

class Solution {
    public int maxProfit(int[] prices) {
       
       /*
        int n = prices.length;
        int dp[][] = new int[prices.length+1][2];
        for (int d[] : dp) {
            Arrays.fill(d, -1);
        }
      int profit = 0;

        dp[n][0] = dp[n][1] = 0;
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                if (buy == 0) { // We can buy the stock
                    profit = Math.max(0 + dp[ind + 1][0], -prices[ind] + dp[ind + 1][1]);
                }

                if (buy == 1) { 
                    profit = Math.max(0 + dp[ind + 1][1], prices[ind] + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
        */
        int sum =0;
        for(int i =0;i<prices.length-1;i++){
            if(prices[i+1] > prices[i]){
                sum += prices[i+1] - prices[i];
            }

        }

  return sum;
       // return func(prices, 0, 1, dp);
    }

    int func(int prices[], int day, int canBuy, int dp[][]) {
        if (day == prices.length) {
            return 0;
        }

        if (dp[day][canBuy] != -1) {
            return dp[day][canBuy];
        }

        int profit = 0;
        if (canBuy == 1) {
            profit = Math.max(-prices[day] + func(prices, day + 1, 0, dp), func(prices, day + 1, 1, dp));
        } else {
            profit = Math.max(prices[day] + func(prices, day + 1, 1, dp), func(prices, day + 1, 0, dp));
        }

        dp[day][canBuy] = profit;
        return profit;
    }
}
