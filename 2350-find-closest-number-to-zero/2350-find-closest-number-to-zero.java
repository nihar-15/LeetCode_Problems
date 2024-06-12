class Solution {
    public int findClosestNumber(int[] arr) {
     int ans = Integer.MAX_VALUE;
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
        int n = arr.length , k = 1;
        for(int i =0;i<n ;i++){
           
            pq.offer(new Pair(Math.abs(arr[i]-0) , arr[i]));
           
            if(pq.size() > k){
                pq.poll();
            }
        }
        
          Pair p = pq.remove();
          ans = p.a;
        return ans;
    }
}

class Pair implements Comparable<Pair>{
    int a , diff;
     public Pair(int diff,int a ){
        this.a=a;
        this.diff=diff;
        
    }
    
 
    public int compareTo(Pair p2){
        if(this.diff-p2.diff!=0){
            return p2.diff- this.diff;
        }
        return this.a-p2.a;
    }
}