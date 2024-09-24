class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        int ans = 0 ;
        for(int num : arr1){
            while(!set.contains(num) && num > 0){
                set.add(num);
                num /= 10;
            }
        }
         for(int num : arr2){
            while(!set.contains(num) && num > 0){
                num /= 10;
            }
             if (num > 0) {
                ans = Math.max(ans, (int)(Math.log10(num) + 1));
            }
        }
  return ans;
    }
}
      