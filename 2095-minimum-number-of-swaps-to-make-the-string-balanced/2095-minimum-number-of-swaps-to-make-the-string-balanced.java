class Solution {
    public int minSwaps(String s) {
        int swap = 0;
        for(int x=0;x<s.length();x++){
            if(s.charAt(x) == '[') swap++;
            else if(swap > 0) swap--;
        }
        return (swap+1)/2; 
    }
}