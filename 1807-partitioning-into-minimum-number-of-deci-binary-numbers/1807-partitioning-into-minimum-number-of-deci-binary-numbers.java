class Solution {
    public int minPartitions(String s) {
        int max =0;
        for(int i=0;i<s.length();i++){
         int digit = s.charAt(i)-'0';
         max = Math.max(max , digit);
        }
        return max;
    }
}