class Solution {
    public boolean checkInclusion(String s1, String s2) {
       
        if (s1.length() > s2.length())
            return false;
        int[] s1arr = new int[26];
        int[] s2arr = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1arr[s1.charAt(i) - 'a']++;
            s2arr[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1arr, s2arr))
                return true;
            s2arr[s2.charAt(i + s1.length()) - 'a']++;
            s2arr[s2.charAt(i) - 'a']--;
        }
        return matches(s1arr, s2arr);
    }
    
    public boolean matches(int[] s1arr, int[] s2arr) {
        for (int i = 0; i < 26; i++) {
            if (s1arr[i] != s2arr[i])
                return false;
        }
        return true;
    /*int freq[] = new int[26];
       int characters = 0 ;
       int left = 0 ,  right = 0;
       int n = s2.length();
       Set<Character> set = new HashSet<>();
       for(int i = 0 ; i< s1.length() ; i++){
        freq[s1.charAt(i) - 'a']++;
        set.add(s1.charAt(i));
        if(freq[s1.charAt(i) - 'a'] == 1){
            characters++;
        }
       }
      while( right < n ){
        char curr = s2.charAt(right);
         if(set.contains(curr)){
            if(freq[curr - 'a'] == 0){
           
              right++;
                while(left < right){
                    if(set.contains(s2.charAt(left))){
                        freq[s2.charAt(left) -'a']++;
                        if(freq[s2.charAt(left) -'a'] == 1){
                            characters++;
                        }
                    }
                    left++;
                }
             
            }else{
                right++;
                freq[curr - 'a']--;
                if(freq[curr - 'a'] == 0){
                    characters--;
                }
                if(characters == 0){
                    return true;
                }
            }
         }else{       
            right++;
             while(left < right){
                    if(set.contains(s2.charAt(left))){
                        freq[s2.charAt(left) -'a']++;
                        if(freq[s2.charAt(left) -'a'] == 1){
                            characters++;
                        }
                    }
                    left++;
                }
         }
      }
      return false; 
      */
    }
}