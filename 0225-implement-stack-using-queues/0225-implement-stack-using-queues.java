class MyStack {
     Deque<Integer> deque; 
    public MyStack() {
        deque = new ArrayDeque<>();
    }
    
    public void push(int x) {
        deque.addLast(x);
    }
    
    public int pop() {
        if(!deque.isEmpty()){
            return deque.removeLast();
        }
         return -1;
    }
    
    public int top() {
         if(!deque.isEmpty()){
            return deque.getLast();
        }
         return -1;
    }
    
    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */