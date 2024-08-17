class Solution {
    public int mincostTickets(int[] days, int[] costs) {
     Set<Integer> set = new HashSet<>();
     int dp[] = new int[367];
     Arrays.fill(dp , -1);
     for(int d : days){
        set.add(d);
     }
     return func(days , costs , 0 , set , dp);
     
    }
    int func(int days[] , int cost[] , int i , Set<Integer> set , int dp[]){
        if(i > 366){
            return 0;
        }

        if(dp[i] != -1){
            return dp[i];
        }  
        if(!set.contains(i)){
            return func(days , cost , i+1 , set , dp);
        }
    
        int oneDay = cost[0] + func(days , cost , i+1 , set , dp);
        int sevenDay = cost[1] + func(days , cost , i+7 , set , dp);
        int thirtyDay = cost[2] + func(days , cost , i+30 , set , dp);

        return dp[i] = Math.min(oneDay , Math.min(sevenDay , thirtyDay));    
    }
}