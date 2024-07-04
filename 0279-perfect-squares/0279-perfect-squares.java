class Solution {
    
    public int numSquares(int n) {
        int arr[] = new int[n+1];
        Arrays.fill(arr , -1);
        return func(n , arr);
    }
    int func(int n , int arr[]){
        if(n ==  0 ){
            return 0;
        }
        if(arr[n] != -1){
             return arr[n];
        }
        int minimumCount = Integer.MAX_VALUE;
        for(int i = 1 ;i*i <= n ; i++){
            int res = 1+ func(n - i*i , arr);
            minimumCount = Math.min(res , minimumCount);
        }
        return arr[n] = minimumCount;
    }
}