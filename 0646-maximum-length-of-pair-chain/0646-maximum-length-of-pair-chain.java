class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Pair[] arr = new Pair[n];
        int i =0 ;
        for(int p[] : pairs){
           arr[i++] = new Pair(p[0] , p[1]);
        }
       Arrays.sort(arr, (a, b) -> a.y - b.y);
        int dp[][] = new int[n+1][n+1];
        for(int d[] : dp){
            Arrays.fill(d , -1);
        }
        
       return func(arr , 0 , -1 , dp);
    }
    int func(Pair[] arr , int idx , int prev , int [][]dp ){
        if(idx >= arr.length){
            return 0;
        }
        if(dp[idx][prev +1] != -1){
            return dp[idx][prev];
        }
        int count1 = 0 , count2 = 0;
        if(prev == -1 || arr[idx].x > arr[prev].y){
            count1 = 1 + func(arr , idx+1, idx , dp);
        }
        count2 = func(arr , idx+1, prev , dp);
        return dp[idx][prev +1] = Math.max(count1 , count2 );
        
    }
}

class Pair{

    int x;
    int y;
    
    public Pair(int a, int b)
    {
        x = a;
        y = b;
    }
}