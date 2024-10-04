class Solution {
    public long dividePlayers(int[] skill) {
        long ans = 0;
        int n = skill.length;
        int left = 0 , right = n-1 ; 
        Arrays.sort(skill);
        int sum = skill[left] + skill[right] ;
        while(left < right){
            int currentSum = skill[left] + skill[right];
            if(currentSum != sum){
                return -1;
            }
            ans += (skill[left] * skill[right]);
            right--;
            left++;
        }
        return ans;
    }
}