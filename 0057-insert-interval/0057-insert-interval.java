class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      List<int[]> mergedIntervals = new ArrayList<>();

      int i = 0;
      while(i < intervals.length){
         if(intervals[i][1] < newInterval[0]){
            mergedIntervals.add(intervals[i]);
         }else if(intervals[i][0] > newInterval[1]){
            break;
         }else {
            newInterval[0] = Math.min(newInterval[0] , intervals[i][0]);
             newInterval[1] = Math.max(newInterval[1] , intervals[i][1]);
         }
         i++;
      }
      mergedIntervals.add(newInterval);
      while(i <intervals.length){
        mergedIntervals.add(intervals[i]);
        i++;
      }

      return mergedIntervals.toArray(new int[mergedIntervals.size()][2]);
    }
}