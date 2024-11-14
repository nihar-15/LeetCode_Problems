class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
     int low =1 ; 
     int high = 0 ; 
     for(int q : quantities){
        high = Math.max(q , high);
     }   
     while(low <= high){
        int mid = (low + high) / 2;
        boolean isPossible = func(n , quantities  , mid);
        if(isPossible){
           high = mid - 1;
        }else{
           low = mid +1 ;
        }
     }
     return high + 1;
    }
     private boolean func(int n, int[] quantities, int maxPerStore) {
        int storeCount = 0; 

        for (int q : quantities) {
          
            storeCount += (q + maxPerStore - 1) / maxPerStore; 
        }

        return storeCount <= n;
    }
}