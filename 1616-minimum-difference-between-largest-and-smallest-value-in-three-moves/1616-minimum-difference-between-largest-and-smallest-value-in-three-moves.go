func minDifference(nums []int) int {
    if(len(nums) <= 4){
        return 0;
    }
    sort.Ints(nums);
    minDiff := int(^uint(0) >> 1)
   for left := 0 ; left <= 3 ;left++{
    diff := nums[len(nums) - 4 + left] - nums[left]
    if(diff < minDiff){
        minDiff = diff
    }
   }
   return minDiff
}