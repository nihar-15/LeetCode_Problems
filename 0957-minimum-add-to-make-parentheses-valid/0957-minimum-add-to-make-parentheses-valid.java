class Solution {
    public int minAddToMakeValid(String s) {
     int count = 0;
     Stack<Character> stack = new Stack<>();
     for(int i = 0 ; i < s.length() ; i++){
      char curr = s.charAt(i);
      if(curr == '('){
        stack.push(curr);
      }else if(stack.isEmpty() && curr == ')'){
        count ++;
      }else {
        stack.pop();
      }
     } 

     return count + stack.size();
    }
}