class Solution {
    public String largestNumber(int[] nums) {
        String ans = "";
        PriorityQueue<String> pq = new PriorityQueue<String>( new MyComparator());
        for(int num : nums){
            pq.offer( Integer.toString(num));
        }
        while(!pq.isEmpty()){
            ans += pq.poll();
        }
        if (ans.charAt(0) == '0') {
            return "0";
        }
        return ans ;
    }
}
class MyComparator implements Comparator<String> {
    public int compare(String s1, String s2) {
        String s1s2 = s1 + s2;
        String s2s1 = s2 + s1;
        
        return s2s1.compareTo(s1s2);
    }
}