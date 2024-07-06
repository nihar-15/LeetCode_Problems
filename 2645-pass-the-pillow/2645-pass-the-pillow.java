class Solution {
    public int passThePillow(int n, int time) {
        int pos = 0;
        int dir = 1;
        for(int i = 0;i<time;i++){
            if(dir == 1){
                if(pos == n-1){
                    dir =-1;
                }
                pos += dir;
            }else{
                if(pos == 0){
                    dir = 1;
                }
                pos += dir;
            }
        }
        return pos +1;
    }
}