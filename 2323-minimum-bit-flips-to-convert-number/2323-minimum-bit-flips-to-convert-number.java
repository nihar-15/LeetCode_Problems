class Solution {
    public int minBitFlips(int start, int goal) {
        
        int ans=0;
        for(int bit =0;bit<31;bit++){
            int s = (1 << bit) & start;
            int g = (1 << bit) & goal;
            if(s != g){
                ans++;
            }
        }
        return ans;
    }
}