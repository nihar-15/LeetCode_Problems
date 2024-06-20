class Solution {
    public int maxDistance(int[] position, int m) {
        int n =position.length;
        Arrays.sort(position);
        int minDist =1 , maxDist = position[n-1];
        while(minDist <= maxDist){
            int mid= (minDist + maxDist)/2;
            if(isPossible(position , mid , m)){
                minDist = mid+1;
            }else{
                maxDist = mid-1;
            }
        }
        return minDist-1;
    }
    boolean isPossible(int position[] , int dis, int m ){
        int prev = position[0];
        int balls =1;
        for(int i =1;i< position.length;i++){
            int curr = position[i];

            if(curr-prev >= dis){
                balls++;
                prev = curr;
            }

            if(balls == m){
               break;
            }
        }
        return balls == m;
    }
}