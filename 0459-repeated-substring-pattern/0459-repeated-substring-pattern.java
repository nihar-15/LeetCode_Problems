class Solution {
    public boolean repeatedSubstringPattern(String s) {
      
        int n = s.length();
        for(int i = n/2;i>0;i--){
            if(n%i == 0){
                int len = n/i;
                String str = "";
                 for (int j = 0; j < len; j++) {
                    str += s.substring(0, i);
                }
                if (str.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}