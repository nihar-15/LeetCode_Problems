func nonSpecialCount(l int, r int) int {
    lim := int(math.Sqrt(float64(r)))
	isPrime := make([]bool, lim+1)
	for i := 2; i <= lim; i++ {
		isPrime[i] = true
	}
	isPrime[0] = false
	isPrime[1] = false

	for i := 2; i*i <= lim; i++ {
		if isPrime[i] {
			for j := i * i; j <= lim; j += i {
				isPrime[j] = false
			}
		}
	}

	cnt := 0
	for i := 2; i <= lim; i++ {
		if isPrime[i] {
			square := i * i
			if square >= l && square <= r {
				cnt++
			}
		}
	}

	totalCount := r - l + 1
	return totalCount - cnt
}