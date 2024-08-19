class Solution {
    public int minSteps(int n) {
         if (n == 1) {
            return 0;
        }
        return func(1 , n, 1) +1 ;
    }
    int func(int current , int target , int last){
      
        if (current == target) {
            return 0;
        }

        if (current > target) {
            return target;
        }

        int copy = Integer.MAX_VALUE;
        int paste = 1+  func(current + last , target , last);
        if(current != last){
            copy = 1 + func(current , target , current);
        }

        return Math.min(copy , paste) ;
    }
}