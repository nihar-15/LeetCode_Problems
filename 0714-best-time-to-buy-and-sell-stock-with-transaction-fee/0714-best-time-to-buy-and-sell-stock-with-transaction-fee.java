class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length+1][2];
       /* for(int d[]: dp){
            Arrays.fill(d , -1);
        }
        */
      for(int day =  prices.length-1 ;day>=0; day -- ){
        for(int canBuy=0;canBuy<=1; canBuy++){
            if(canBuy == 1){
                dp[day][canBuy] = Math.max(-prices[day] + dp[day+1][0] , dp[day+1][1]);
            }else{
                dp[day][canBuy]  =    Math.max( prices[day]+dp[day+1][1]-fee , dp[day+1][0]);
            }
        }
      }

   return dp[0][1];
        //return  func(prices ,0 , 1, fee ,dp);
    }
    int func(int prices[] , int day , int canBuy , int fee , int dp[][]){
       if(prices.length == day){
        return 0;
       }
       if(dp[canBuy][day]  != -1){
        return dp[canBuy][day] ;
       }
        if(canBuy == 1){
            return dp[canBuy][day] = Math.max(-prices[day] + func(prices, day+1 , 0 , fee ,dp) , func(prices, day+1 ,1, fee ,dp));
        }
        return dp[canBuy][day] = Math.max( prices[day]+func(prices , day+1 , 1 , fee, dp)-fee , func(prices , day+1 , 0 , fee, dp));
    }

}