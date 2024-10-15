class Solution {
    public long minimumSteps(String s) {
         long ans = 0;
        long cnt = 0;
        for(char c:s.toCharArray()){
            if(c == '0'){
                ans += cnt;
            }else{
                cnt++;
            }
        }
        return ans;
    }
}