class Solution {
    public String reverseParentheses(String s) {
         Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                st.push(i);
            } else if (sb.charAt(i) == ')') {
                int start = st.pop();
                reverse(sb, start + 1, i - 1);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '(' && sb.charAt(i) != ')') {
                result.append(sb.charAt(i));
            }
        }
        
        return result.toString();
    }
    
    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}