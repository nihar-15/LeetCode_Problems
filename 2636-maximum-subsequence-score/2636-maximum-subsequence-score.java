class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        ArrayList<Pair> arr = new ArrayList<>();
        for(int i =0;i<nums1.length;i++){
           arr.add(new Pair(nums1[i] , nums2[i]));
        }
 PriorityQueue<Integer> pq = new PriorityQueue<>();
        Collections.sort(arr);
        long  kSum = 0 ;

        for(int i = 0;i<=k-1;i++){
            kSum += arr.get(i).a;
            pq.offer(arr.get(i).a) ;
        }
        long result = kSum * arr.get(k - 1).b;

        for (int i = k; i < arr.size(); i++) {
            pq.offer(arr.get(i).a);
            kSum += arr.get(i).a - pq.poll();  // Correctly update kSum

            result = Math.max(result, kSum * arr.get(i).b);
        }

        return result;
    }
}
class Pair implements Comparable<Pair> {
    int a, b;

    Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public int compareTo(Pair other) {
        return Integer.compare(other.b, this.b); // Descending order based on b
    }
}