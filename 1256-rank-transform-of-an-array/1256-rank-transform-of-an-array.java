import java.util.*;

class Solution {
    public int[] arrayRankTransform(int[] arr) {
        if (arr.length == 0) return new int[0];

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;
    
        for (int num : sortedArr) {
            if (!rankMap.containsKey(num)) {
                rankMap.put(num, rank++);
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rankMap.get(arr[i]);
        }
        
        return arr;
    }
}