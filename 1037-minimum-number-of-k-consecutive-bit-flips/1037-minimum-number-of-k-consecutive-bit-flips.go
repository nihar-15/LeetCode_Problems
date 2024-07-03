func minKBitFlips(nums []int, k int) int {
    n := len(nums)
    arr:= make([]bool, n)
    flips := 0
    flipCount :=  0 
    for  i:= 0 ;i < n ;i++{
        if(i >= k &&  arr[i - k] == true ){
            flipCount --
        }
        if(flipCount %2 == nums[i]){
            if(i + k > n){
                return -1
            }
            flipCount++
            flips++
            arr[i] = true
        }
    }
    return flips
}