class Solution {
    public boolean checkValidString(String s) {
      Boolean dp[][][] = new Boolean[s.length()][s.length()][s.length()];
        return func(s, 0, 0, 0, dp);
    }

    boolean func(String s, int open, int star, int idx, Boolean[][][] dp) {
        if (open < 0) {
            return false; 
        }
        if (idx >= s.length()) {
            return open == 0; 
        }
        if (dp[open][star][idx] != null) {
            return dp[open][star][idx];
        }
        if (s.charAt(idx) == '(') {
            return dp[open][star][idx] = func(s, open + 1, star, idx + 1, dp);
        }
        if (s.charAt(idx) == ')') {
            return dp[open][star][idx] = func(s, open - 1, star, idx + 1, dp);
        }
        // If it's '*', try all possibilities 
        return dp[open][star][idx] = (func(s, open + 1, star, idx + 1, dp) ||  
                                      func(s, open - 1, star, idx + 1, dp) || 
                                      func(s, open, star + 1, idx + 1, dp));
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
