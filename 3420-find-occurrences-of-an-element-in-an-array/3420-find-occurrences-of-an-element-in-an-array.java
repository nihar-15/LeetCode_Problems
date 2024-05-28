class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int len = nums.length;
        List<Integer> nm = new ArrayList<Integer>();
        for(int i=0;i<len;i++)
        {
            if(x==nums[i])
            {
                nm.add(i);
            }
        }
        len=queries.length;
        int ans[] = new int[len];
        for(int i =0;i<len ; i++){
            int val =  queries[i];

            ans[i] =val >nm.size() ? -1 : nm.get(val -1);
        }
        return ans;
    }
}