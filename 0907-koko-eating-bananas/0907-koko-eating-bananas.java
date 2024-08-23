class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int p : piles){
            high = Math.max(high , p);
        }
        while(low < high){
            int mid = (low +high)/ 2;
            if(canEat(piles , mid , h)){
              high = mid;
            }else{
               low = mid+1;
            }
        }
        return low ;
    }
    boolean canEat(int piles[] , int k , int h){
        int hrsRequired = 0;
        for(int i =0 ; i<piles.length ; i++){
            hrsRequired += (piles[i] / k);
            if(piles[i] % k != 0){
               hrsRequired++;
            }
        }
        return hrsRequired <= h ;
    }
}