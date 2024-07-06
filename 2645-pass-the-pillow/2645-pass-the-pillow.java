class Solution {
    public int passThePillow(int n, int time) {
  int cycleLength = (n - 1) * 2;
        int cyclePosition = time % cycleLength;
        if (cyclePosition < n) {
            return cyclePosition + 1;
        } else {
            return cycleLength - cyclePosition + 1;
        }
    }
}