class Solution {
    public int characterReplacement(String s, int k) {
        int map[] = new int[26];
        int n = s.length();
        int left =0 , right =0 ;
        int maxFrequency = 0;
        int ans = 0;
        while(right < n){
           map[s.charAt(right) - 'A']++;
           if( map[s.charAt(right) - 'A'] > maxFrequency){
               maxFrequency =  map[s.charAt(right) - 'A'];
           }
         
           if( (right - left + 1 )- maxFrequency > k){
             map[s.charAt(left) - 'A']--;
             left++;
           }
           ans = Math.max(ans , right - left +1); 
           right++;
        }
        return ans;
    }
}