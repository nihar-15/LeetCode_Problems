class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int left=0,n=s.length(),maxLength=0;
        int freq[] = new int[128];
        for( int right=0;right<n; right++){
            char currentChar = s.charAt(right);
            freq[currentChar]++;
            
            while( freq[currentChar] >1 ){
                char leftChar = s.charAt(left);
                freq[leftChar]--;
                left++;
            }
              maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
        
    }
}


