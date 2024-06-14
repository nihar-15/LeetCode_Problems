class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();

        for(int i : nums ){
            map.put(i , map.getOrDefault(i , 0)+1);
        }

   PriorityQueue<Pair>pq = new PriorityQueue<>();
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
              pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        int ans[] = new int[nums.length];
        int k =0;
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            for(int i =1;i<=p.freq;i++){
                ans[k++]=p.ele;
            }
        } 

        return ans;
    }
}
class Pair implements Comparable<Pair> {
    int ele, freq;

  
    public Pair(int ele, int freq) {
        this.ele = ele;
        this.freq = freq;
    }

    // compareTo method to sort by increasing order of frequency
    // and decreasing order of element value
    @Override
    public int compareTo(Pair other) {
        if (this.freq != other.freq) {
            return Integer.compare(this.freq, other.freq); // Increasing order of frequency
        } else {
            return Integer.compare(other.ele, this.ele); // Decreasing order of element value
        }
    }
    
}