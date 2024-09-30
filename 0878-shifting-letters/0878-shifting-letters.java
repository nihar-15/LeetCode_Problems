class Solution {
    public String shiftingLetters(String s, int[] shifts) {
       int n = shifts.length;
        int [] prefixSum =  new int [n];
        char [] str = s.toCharArray();
        
        prefixSum[n-1] = shifts[n-1];
        for(int i=n-2;i>=0;i--){
            prefixSum[i] = (prefixSum[i+1]+ shifts[i]) %26;
        }

        for(int i=0;i<str.length;i++){
            str[i] = (char) ( (((str[i]-'a')+prefixSum[i])%26) + 'a' );
        }
        return new String(str);
    }
}