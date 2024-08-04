func rangeSum(nums []int, n int, left int, right int) int {
  storeSubarray := []int{}
	for i := 0; i < len(nums); i++ {
		sum := 0
		for j := i; j < len(nums); j++ {
			sum += nums[j]
			storeSubarray = append(storeSubarray, sum)
		}
	}

	sort.Ints(storeSubarray)

	rangeSum := 0
	mod := int(1e9 + 7)
	for i := left - 1; i <= right - 1; i++ {
		rangeSum = (rangeSum + storeSubarray[i]) % mod
	}
	return rangeSum
}
