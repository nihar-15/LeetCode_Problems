class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int n = s.length();
        int left = 0 , right = 0;
    
        while(right < n){
           right ++;
           if(right - left == 10){
            String  substring = s.substring(left , right );
            if(set.contains(substring) && !ans.contains(substring)){
                ans.add(substring);
            }else{
                set.add(substring);
            }
            left++;
           }
        }
        return ans;
    }
}