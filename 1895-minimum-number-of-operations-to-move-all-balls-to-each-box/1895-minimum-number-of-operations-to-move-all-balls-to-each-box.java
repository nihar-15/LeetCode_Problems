class Solution {
    public int[] minOperations(String boxes) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < boxes.length(); i++) {
            if (boxes.charAt(i) == '1') {
                set.add(i);
            }
        }
        int ans[] = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            int sum = 0;
            Iterator<Integer> value = set.iterator(); 
            while (value.hasNext()) {
                sum += Math.abs(i - value.next()); 
            }
            ans[i] = sum;
        }
        return ans;
    }
}