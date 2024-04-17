class Solution {
    private int[] computeLPS(String s){
        int i=1 , len=0;
        int lps[] = new int[s.length()];

        while(i< s.length()){
            if(s.charAt(i) == s.charAt(len)){
                ++len;
                lps[i]= len;
                ++i;
            }else{
                if(len==0){
                    lps[i]=len;
                    ++i;
                }else{
                    len = lps[len-1];
                }
            }
        }

        return lps;
    }
    public int strStr(String haystack, String needle) {
         if(needle.length() > haystack.length()){
            return -1;
         }
         int lps[] = computeLPS(needle);
         int i=0, j=0;
         while(i <= haystack.length()){
            if(j== needle.length()){
                    return i-j;
                }
            
            if(i< haystack.length() && haystack.charAt(i)==needle.charAt(j)){
                i++;
                j++;
               
            }else{  
                if(j==0){
                   i++;
                }else{
                    j=lps[j-1];
                }
            }

         }


return -1;
         
    }
}