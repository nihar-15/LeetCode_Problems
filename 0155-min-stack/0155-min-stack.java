class MinStack {
       Stack<Integer> stk;
        Stack<Integer> helper;
       
    public MinStack() {
        stk = new Stack<>();
        helper = new Stack<>();
    }
    
    public void push(int val) {
      stk.push(val);
      if(!helper.isEmpty()){
        if(helper.peek() > val){
             helper.push(val);
            
        }else{
           helper.push(helper.peek());
        }

      }else{
        helper.push(val);
      }
    }
    
    public void pop() {
        if(!stk.isEmpty()){
            int val =  stk.peek();
            stk.pop();
            helper.pop();
           // return val;
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return helper.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */