import java.util.*;

class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        int[] diff = new int[n];
        int ans = 0;

        // Calculate the difference between reward1 and reward2
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
            ans += reward2[i]; // Initially add all rewards from reward2
        }

        // Sort the differences in descending order
        Arrays.sort(diff);

        // Add the top k differences to the result
        for (int i = 0; i < k; i++) {
            ans += diff[n - 1 - i]; // Picking the k largest differences
        }

        return ans;
    }
}
