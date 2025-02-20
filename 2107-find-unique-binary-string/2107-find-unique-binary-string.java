class Solution {
    String ans = "";

    public String findDifferentBinaryString(String[] nums) {
        Set<String> set = new HashSet<>(Arrays.asList(nums));
        int n = nums[0].length();
        backtrack("", n, set);
        return ans;
    }

    void backtrack(String str, int n, Set<String> set) {
        if (str.length() == n) {
            if (!set.contains(str)) {
                ans = str;
            }
            return;
        }

        if (!ans.equals("")) return; 

        backtrack(str + '0', n, set);
        if (!ans.equals("")) return; // Stop recursion when ans is found

        backtrack(str + '1', n, set);
    }
}
