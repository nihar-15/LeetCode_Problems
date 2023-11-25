class Solution {
    public List<String> generateParenthesis(int n) {
        
        List<String> ans=  new ArrayList<>();
        
        
        
        
        fun(ans,"",n,n);
        
        return ans;
    }
    
    public void fun(List<String> ans,String comb,int open,int close){
        
        if(open==0 && close ==0 && (isValid(comb))==true){
            ans.add(comb);
        }
        
        if(open>0){
            fun(ans,comb+')',open-1,close);
        }
        
         
        if(close>0){
            fun(ans,comb+'(',open,close-1);
        }
    }
    
    
    
    public boolean isValid(String s) {
        int balance = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
                if (balance < 0) {
                    return false; // More closing parentheses than opening ones
                }
            }
        }
        return balance == 0; // True if balanced, false otherwise
    }
}