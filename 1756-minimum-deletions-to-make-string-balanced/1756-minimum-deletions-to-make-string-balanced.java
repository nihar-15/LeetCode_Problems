class Solution {
    public int minimumDeletions(String s) {
         int n = s.length();
         Stack<Character> stack = new Stack<>();
         int cnt =0;
         for(int i =0 ; i< n ; i++){
            if(!stack.isEmpty() && (stack.peek() == 'b' && s.charAt(i) == 'a')){
                stack.pop();
                cnt++;
            }else{
                stack.push(s.charAt(i));
            }
         }
         return cnt ;
    }
}