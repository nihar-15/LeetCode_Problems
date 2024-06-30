func maximumLength(nums []int) int {
   n := len(nums)
	alter, odd, even := 1, 0, 0

	if nums[0] % 2 == 0 {
		even++
	} else {
		odd++
	}

	lastOdd := (nums[0] % 2 != 0)
	for i := 1; i < n; i++ {
		flag := (nums[i] % 2 == 0)
		if flag {
			if lastOdd {
				alter++
				lastOdd = false
			}
			even++
		} else {
			if !lastOdd {
				alter++
				lastOdd = true
			}
			odd++
		}
	}
	return max(alter, max(odd, even))
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}