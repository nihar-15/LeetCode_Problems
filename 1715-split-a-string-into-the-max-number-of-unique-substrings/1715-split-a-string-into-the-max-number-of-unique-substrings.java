class Solution {
    public int maxUniqueSplit(String s) {
     return func(s, new HashSet<>(), 0);
    }

    private int func(String s, Set<String> set, int start) {
        if (start == s.length()) {
            return 0; 
        }
        int maxSplits = 0 ; 
        for(int end = start  + 1; end <= s.length() ; end++){
            String subStr = s.substring(start , end);
             if(!set.contains(subStr)){
                set.add(subStr);
                maxSplits = Math.max(maxSplits , 1 + func(s , set , end));
                set.remove(subStr);
             }
        }
        return maxSplits;
    }
}