class Solution {
    public int[] finalPrices(int[] prices) {
   

        int n = prices.length;
        int[] discount = new int[n];
        Stack<Integer> stk = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek() > prices[i]) {

                stk.pop();

            }

            if (!stk.isEmpty()) {

                discount[i] = stk.peek();
            }
            stk.push(prices[i]);
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i] - discount[i];
        }

        return ans;
    }
}