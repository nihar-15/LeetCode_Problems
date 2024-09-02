class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for(int x : chalk) {
            sum += x;
        }
        long div = k / sum;
        k -= (sum * div);
        for(int i=0; i<chalk.length; i++) {
            if(chalk[i] <= k) {
                k -= chalk[i];
            }
            else {
                return i;
            }
        }
        return -1;
    }
}