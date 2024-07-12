class Solution {
    public int maximumGain(String s, int x, int y) {
          StringBuilder sb = new StringBuilder(s);
          int score1 = 0 , score2 = 0; 
          if(x > y){
             score1 = remove(sb, "ab", x);
             score1 += remove(sb , "ba" , y);
          }else{
                score2 = remove(sb, "ba", y);
                score2 += remove(sb , "ab" , x);
          }
       
        return Math.max(score1 , score2);
    }

    int remove(StringBuilder sb, String target, int score) {
        int ans = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < sb.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(sb.charAt(i));
            } else {
                if (stack.peek() == target.charAt(0) && sb.charAt(i) == target.charAt(1)) {
                    stack.pop();
                    ans += score;
                } else {
                    stack.push(sb.charAt(i));
                }
            }
        }

        // Build the remaining string after processing
        StringBuilder remaining = new StringBuilder();
        while (!stack.isEmpty()) {
            remaining.insert(0, stack.pop());
        }

        // Update the original StringBuilder
        sb.setLength(0);
        sb.append(remaining);

        return ans;
    }
}