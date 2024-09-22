class Solution {
    public List<Integer> lexicalOrder(int n) {
     List<Integer> ans = new ArrayList<>();
     for(int i = 1; i <= 9 ; i++){
          func(i, n , ans);
     }
     
     return ans;
    }
    public void func(int curr , int n , List<Integer> ans){
        if(curr > n){
            return ;
        }
        ans.add(curr);
        for (int nextDigit = 0; nextDigit <= 9; nextDigit++) {
            int nextNum = curr * 10 + nextDigit;
            if(nextNum > n){
                return;
            }
            func(nextNum , n , ans);
    }
}
}