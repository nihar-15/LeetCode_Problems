class Solution {
    public String smallestNumber(String pattern) {
       int count = 1; 
       StringBuilder str = new StringBuilder(); 
       Stack<Character> stack = new Stack<>(); 
       for(int i = 0 ; i <= pattern.length() ; i++){
        stack.push((char) ('0' + count++));

        if(i == pattern.length() || pattern.charAt(i) == 'I' ){
            while(!stack.isEmpty()){
                str.append(stack.pop());
            }
        }
       }
       return str.toString();
    }
}