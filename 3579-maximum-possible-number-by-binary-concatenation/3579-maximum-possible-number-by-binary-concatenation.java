class Solution {
    public int maxGoodNumber(int[] nums) {
        
       String []binaries = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            binaries[i] = Integer.toBinaryString(nums[i]);
        }
        Arrays.sort(binaries , (a, b)->(b+a).compareTo(a+b));
        StringBuilder ans = new StringBuilder();
        for(String binary :binaries){
            ans.append(binary);
        }
        return Integer.parseInt(ans.toString() , 2);
    }
}