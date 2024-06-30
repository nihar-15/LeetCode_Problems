class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(fun(red , blue) , fun(blue , red));
    }
    int fun(int ball1 , int ball2){
        int balls = 1; 
        boolean flag = true;
        while(true){
            if(flag){
                if(balls <= ball1){
                    ball1 -= balls;
                }else{
                    break ;
                }
            }else{
                if(balls <= ball2){
                    ball2 -= balls;
                }else{
                    break;
                }
            }
            balls++;
            flag = !flag;
        }
        return balls -1;
    }
}