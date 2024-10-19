class Solution {
   Map<String,Boolean> memo=new HashMap();
    public boolean checkValidString(String s) {
         return helper(s,0,0);
    }
    public boolean helper(String s, int i,int bal){
        if(i==s.length()){
            if(bal==0){
                return true;
            }
            return false;
        }
        if(bal<0){
            return false;
        }
        String k= bal+":"+i;
        if(memo.containsKey(k)){
            return memo.get(k);
        }
        boolean ans=false;
        if(s.charAt(i)=='('){
            ans= helper(s,i+1,bal+1);
        }else if (s.charAt(i)==')'){
            ans= helper(s,i+1,bal-1);
        }else if (s.charAt(i)=='*'){
            ans=helper(s,i+1,bal+1) || helper(s,i+1,bal-1) || helper(s,i+1,bal);
        }
        memo.put(k,ans);
        return ans;
    }
}

/*
              
        Stack<Integer> openStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                openStack.push(i);
            } else if (curr == '*') {
                starStack.push(i);
            } else if (curr == ')') {
                if (!openStack.isEmpty()) {
                    openStack.pop();
                } else if (!starStack.isEmpty()) {
                    starStack.pop();
                } else {
                    return false;
                }
            }
        }

      
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.pop() > starStack.pop()) {
                return false;
            }
        }

     
        return openStack.isEmpty();

        */
