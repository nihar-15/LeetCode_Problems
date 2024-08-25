class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count =0 ;
        int n = intervals.length ;
        Arrays.sort(intervals, (o1, o2) -> o1[1] - o2[1]);
        int i =0 , j =1;
        while( j < n){
            int current_end = intervals[i][1];
            int next_start = intervals[j][0];
            int next_end = intervals[j][1];

            if(current_end <= next_start){
                i = j;
                j++;

            }else {
                if(current_end > next_end){
                    i = j;
                    count++;
                }else{
                    j ++;
                    count ++;
                }
            }
        }
        return count;
    }
}