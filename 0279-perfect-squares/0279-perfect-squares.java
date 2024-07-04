class Solution {
    int arr[] = new int[1000001];
    public int numSquares(int n) {
        Arrays.fill(arr , -1);
        return func(n);
    }
    int func(int n){
        if(n ==  0 ){
            return 0;
        }
        if(arr[n] != -1){
             return arr[n];
        }
        int minimumCount = Integer.MAX_VALUE;
        for(int i = 1 ;i*i <= n ; i++){
            int res = 1+ func(n - i*i);
            minimumCount = Math.min(res , minimumCount);
        }
        return arr[n] = minimumCount;
    }
}