class Solution {
     long maxTime =  0 ;
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
      if (workerTimes.length == 1) {
            long h = (long) mountainHeight;
            long workerTime = (long) workerTimes[0];
            return workerTime * (h * (h + 1)) / 2;
        }
     
        long low = 1 , high = (long)1e12; 
        
        while(low < high){
            long mid = (low + high) / 2;
            boolean a  = func(mountainHeight , workerTimes , mid);
            if(a){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
            return low ;
        
    }
    boolean func(int mountainHeight , int workerTimes[] , long mid){
       long heightReduced = 0;

        for (int workerTime : workerTimes) {
            long heightReducedByWorker = 0;
            long totalTime = 0;
            
            for (int x = 1; ; x++) {
                totalTime += workerTime * x;
                if (totalTime > mid) break;
                heightReducedByWorker++;
            }
            
          heightReduced += heightReducedByWorker;

            if (heightReduced >= mountainHeight) {
                return true; 
            }
        }

        return  heightReduced >= mountainHeight;
        
    }
}