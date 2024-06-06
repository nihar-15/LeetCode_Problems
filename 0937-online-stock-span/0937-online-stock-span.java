class StockSpanner {
     Stack<Pair> stack ;
    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span =1;
        while(!stack.isEmpty() &&  price >= stack.peek().price){
            span += stack.pop().span;
        }
        stack.push(new Pair(price , span));
        return stack.peek().span;       
    }
}
class Pair {
    int price;
    int span;

    Pair(int price, int span) {
        this.price = price;
        this.span = span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */