class Solution {
    public double averageWaitingTime(int[][] customers) {
        int avlAt = 0;
        double WaitingTime = 0 ;
        for(int cust[] : customers){
            int arrival = cust[0];
            int t = cust[1];
            avlAt = Math.max(avlAt , arrival) + t;
           WaitingTime += (avlAt - arrival);
        }
        return WaitingTime / customers.length;
    }
}