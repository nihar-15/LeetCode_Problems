class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int i =0 , j = 0;
        Stack<Integer> stack = new Stack<>();
        while(i < pushed.length){
          stack.push(pushed[i]);

          while(j < popped.length &&  !stack.isEmpty() && popped[j] == stack.peek()){
            stack.pop();
            j++;
          }
          i++;
        }
    return stack.isEmpty();
    }
}