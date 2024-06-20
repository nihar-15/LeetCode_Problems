class Solution {
    public int minDeletionSize(String[] strs) {
        int cnt =0;
        for(int i =0;i<strs[0].length();i++){
            int temp =0;
            for(int j =0;j<strs.length;j++){
                int a = strs[j].charAt(i);
                if(a >= temp){
                    temp =a;
                }else{
                    cnt++;
                    break;

                }
            }
        }
        return cnt;
    }
}